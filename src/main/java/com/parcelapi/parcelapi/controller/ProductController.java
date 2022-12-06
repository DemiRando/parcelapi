package com.parcelapi.parcelapi.controller;

import com.parcelapi.parcelapi.Constants;
import com.parcelapi.parcelapi.entity.*;
import com.parcelapi.parcelapi.idInsert;
import com.parcelapi.parcelapi.service.*;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProductController {

    public   idInsert make = new idInsert();

    @Autowired
    private OrderService serve;
    @Autowired
    private CustomerService cserve;
    @Autowired
    private AddressService aserve;
    @Autowired
    private RecipientService rserve;
    @Autowired
    private UserService userService;
    @Autowired
    private CustomerAddressService customerAddressService;

       private Map<String, String> generateJWTToken(User user) {
        long timestamp = System.currentTimeMillis();
        String token = Jwts.builder().signWith(SignatureAlgorithm.HS256, Constants.API_SECRET_KEY)
                .setIssuedAt(new Date(timestamp))
                .setExpiration(new Date(timestamp + Constants.TOKEN_VALIDITY))
                .claim("userId", user.getUserId())
                .claim("email", user.getEmail())
                .claim("firstName", user.getFirstName())
                .claim("lastName", user.getLastName())
                .compact();
        Map<String, String> map = new HashMap<>();
        map.put("token", token);
        return map;
    }

    @PostMapping("/process/addOrder")
    public String addOrder(@RequestBody Map<String, Object> userMap) throws SQLException {
        if (userMap.get("customerID")==null){

        aserve.saveAddress(make.makeRecipientAddressID(userMap));
        aserve.saveAddress(make.makePickupAddressID(userMap));
        cserve.saveCustomer(make.makeCustomerID(userMap));
        rserve.saveRecipient(make.makeRecipientID(userMap));


        int cid = make.getCustomerID(userMap);
        int rid = make.getRecipientID(userMap);
        int rAddressID = make.getRecipientAddressID(userMap);
        int pAddressID= make.getPickupAddressID(userMap);
        customerAddressService.saveCustomerAddress(make.makeCustomerAddressID(cid,pAddressID));
        double distance = make.distance(userMap);
        int fee = make.calculateFee(distance);
        serve.saveOrder(make.makeOrderID(userMap,rid,cid,pAddressID,fee));
        int orderID = make.getOrderID(rid,cid);
       // return "CustomerID:" + cid + "  Recipient AddressID:" + rAddressID + " Customer AddressID:"+pAddressID
       //         + " RecipientID:"+ rid + "OrderID: "+orderID;
            return "Order Placed for Customer ID-"+cid+" Distance-"+distance;
        }
        else {
            aserve.saveAddress(make.makeRecipientAddressID(userMap));
            //aserve.saveAddress(make.makePickupAddressID(userMap));
            rserve.saveRecipient(make.makeRecipientID(userMap));


            int cid = (int)userMap.get("customerID");
            int rid = make.getRecipientID(userMap);
            int rAddressID = make.getRecipientAddressID(userMap);
            int pAddressID= make.getCidAddress(userMap);
            userMap.put("AddID",pAddressID);
            double pLat = make.getCidLat(userMap);
            userMap.put("pLat",pLat);
            double pLong = make.getCidLong(userMap);
            userMap.put("pLon",pLong);
            double distance = make.distance(userMap);
            int fee = make.calculateFee(distance);

            serve.saveOrder(make.makeOrderID(userMap,rid,cid,pAddressID,fee));
            int orderID = make.getOrderID(rid,cid);
            //return "CustomerID:" + cid + "  Recipient AddressID:" + rAddressID + " Customer AddressID:"+pAddressID
              //      + " RecipientID:"+ rid + "OrderID: "+orderID;
            return "Order Placed for Customer ID-"+cid;
        }
    }
/*    @PostMapping("/process/addOrder")
    public String addOrder(@RequestBody orderDetails orderD) throws SQLException {

        aserve.saveAddress(make.makeRecipientAddressID(orderD));
        aserve.saveAddress(make.makePickupAddressID(orderD));
        cserve.saveCustomer(make.makeCustomerID(orderD));
        rserve.saveRecipient(make.makeRecipientID(orderD));


        int cid = make.getCustomerID(orderD);
        int rid = make.getRecipientID(orderD);
        int rAddressID = make.getRecipientAddressID(orderD);
        int cAddressID= make.getPickupAddressID(orderD);

        serve.saveOrder(make.makeOrderID(orderD,rid,cid,cAddressID));
        int orderID = make.getOrderID(rid,cid);
        return "CustomerID:" + cid + "  Recipient AddressID:" + rAddressID + " Customer AddressID:"+cAddressID
                + " RecipientID:"+ rid + "OrderID: "+orderID;
    }

 */

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> registerUser(@RequestBody User user) {
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        String email = user.getEmail();
        String password = user.getPassword();
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(10));
        boolean reg = userService.registerUser(firstName, lastName, email, password);
        if (reg){
            user.setEmail(email.toLowerCase());
            user.setPassword(hashedPassword);
            userService.saveUser(user);}
        return new ResponseEntity<>(generateJWTToken(user), HttpStatus.OK);
    }

    @PostMapping("/login")
   public ResponseEntity<Map<String, String>> loginUser(@RequestBody User user) {
        String email = user.getEmail();
        String password = user.getPassword();
        User login = userService.validateUser(email, password);
        return new ResponseEntity<>(generateJWTToken(login), HttpStatus.OK);

    }
    @PostMapping("/cid")
    public String cid(@RequestBody Map<String, Object> userMap) {
        int cid = (int)userMap.get("customerID") ;
        int pid =(int)userMap.get("addressID") ;
     customerAddressService.saveCustomerAddress(make.makeCustomerAddressID(cid,pid));

        return "Ok";

    }



  /*  @PostMapping("/process/addOrders")
    public String addOrders(@RequestBody List<orderDetails> orders) throws SQLException {
    for (orderDetails orderD:orders){
        aserve.saveAddress(make.makeRecipientAddressID(orderD));
        aserve.saveAddress(make.makePickupAddressID(orderD));
        cserve.saveCustomer(make.makeCustomerID(orderD));
        rserve.saveRecipient(make.makeRecipientID(orderD));


        int cid = make.getCustomerID(orderD);
        int rid = make.getRecipientID(orderD);
        int rAddressID = make.getRecipientAddressID(orderD);
        int cAddressID= make.getPickupAddressID(orderD);

        serve.saveOrder(make.makeOrderID(orderD,rid,cid,cAddressID));



    }
        return "Orders Placed";
    }

   */
  @PostMapping("/process/addOrders")
  public String addOrders(@RequestBody List<Map<String, Object>> maps) throws SQLException {
      for (Map<String, Object> userMap:maps){
         /* aserve.saveAddress(make.makeRecipientAddressID(userMap));
          aserve.saveAddress(make.makePickupAddressID(userMap));
          cserve.saveCustomer(make.makeCustomerID(userMap));
          rserve.saveRecipient(make.makeRecipientID(userMap));


          int cid = make.getCustomerID(userMap);
          int rid = make.getRecipientID(userMap);
          int rAddressID = make.getRecipientAddressID(userMap);
          int cAddressID= make.getPickupAddressID(userMap);
          customerAddressService.saveCustomerAddress(make.makeCustomerAddressID(cid,cAddressID));
          double distance = make.distance(userMap);
          int fee = make.calculateFee(distance);
          serve.saveOrder(make.makeOrderID(userMap,rid,cid,cAddressID,fee));


          */
          if (userMap.get("customerID")==null){

              aserve.saveAddress(make.makeRecipientAddressID(userMap));
              aserve.saveAddress(make.makePickupAddressID(userMap));
              cserve.saveCustomer(make.makeCustomerID(userMap));
              rserve.saveRecipient(make.makeRecipientID(userMap));


              int cid = make.getCustomerID(userMap);
              int rid = make.getRecipientID(userMap);
              int rAddressID = make.getRecipientAddressID(userMap);
              int pAddressID= make.getPickupAddressID(userMap);
              customerAddressService.saveCustomerAddress(make.makeCustomerAddressID(cid,pAddressID));
              double distance = make.distance(userMap);
              int fee = make.calculateFee(distance);
              serve.saveOrder(make.makeOrderID(userMap,rid,cid,pAddressID,fee));

               }
          else {
              aserve.saveAddress(make.makeRecipientAddressID(userMap));
              rserve.saveRecipient(make.makeRecipientID(userMap));


              int cid = (int)userMap.get("customerID");
              int rid = make.getRecipientID(userMap);
              int rAddressID = make.getRecipientAddressID(userMap);
              int pAddressID= make.getCidAddress(userMap);
              userMap.put("AddID",pAddressID);
              double pLat = make.getCidLat(userMap);
              userMap.put("pLat",pLat);
              double pLong = make.getCidLong(userMap);
              userMap.put("pLon",pLong);
              double distance = make.distance(userMap);
              int fee = make.calculateFee(distance);

              serve.saveOrder(make.makeOrderID(userMap,rid,cid,pAddressID,fee));


          }


      }
      return "Orders Placed";
  }

    @GetMapping("/process/orderById/{OrderId}")
    public Order findOrderById(@PathVariable int OrderId) {
        return serve.getOrderById(OrderId);
    }



}
