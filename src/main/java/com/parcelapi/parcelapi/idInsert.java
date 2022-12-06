package com.parcelapi.parcelapi;
import com.parcelapi.parcelapi.entity.*;

import java.sql.*;
import java.util.Map;


public class idInsert {


/*public Customer makeCustomerID(orderDetails orderD)  {
    Customer customer = new Customer();
    String a = orderD.getCustomerTitle();
    String b = orderD.getCustomerFirstName();
    String c = orderD.getCustomerLastName();
    String d =  orderD.getCustomerPhoneNumber();
    String e = orderD.getCustomerEmail();

    customer.setTitle(a);
    customer.setFirstName(b);
    customer.setLastName(c);
    customer.setPhoneNumber(d);
    customer.setEmail(e);

    return customer;
}

 */
    public Customer makeCustomerID(Map<String, Object> userMap)  {
        Customer customer = new Customer();
        String CustomerTitle = (String) userMap.get("customerTitle");
        String CustomerFirstName = (String) userMap.get("customerFirstName");
        String CustomerLastName = (String) userMap.get("customerLastName");
        String CustomerPhoneNumber = (String) userMap.get("customerPhoneNumber");
        String CustomerEmail = (String) userMap.get("customerEmail");

        customer.setTitle(CustomerTitle);
        customer.setFirstName(CustomerFirstName);
        customer.setLastName(CustomerLastName);
        customer.setPhoneNumber(CustomerPhoneNumber);
        customer.setEmail(CustomerEmail);

        return customer;
    }

    public Recipient makeRecipientID(Map<String, Object> userMap)throws SQLException{
    Recipient recipient = new Recipient();

    int addressId = getRecipientAddressID(userMap);

        String RecipientTitle = (String) userMap.get("recipientTitle");
        String RecipientFirstName = (String) userMap.get("recipientFirstName");
        String RecipientLastName = (String) userMap.get("recipientLastName");
        String RecipientPhoneNumber = (String) userMap.get("recipientPhoneNumber");
        String RecipientEmail = (String) userMap.get("recipientEmail");

    recipient.setAddressID(addressId);
    recipient.setFirstName(RecipientFirstName);
    recipient.setTitle(RecipientTitle);
    recipient.setLastName(RecipientLastName);
    recipient.setEmail(RecipientEmail);
    recipient.setPhoneNumber(RecipientPhoneNumber);

    return recipient;
    }
    /*public Recipient makeRecipientID(orderDetails orderDetails)throws SQLException{
        Recipient recipient = new Recipient();
        orderDetails orderD = orderDetails;
        int addressId = getRecipientAddressID(orderD);
        String a = orderD.getRecipientTitle();
        String b = orderD.getRecipientFirstName();
        String c = orderD.getRecipientLastName();
        String d =  orderD.getRecipientEmail();
        String e = orderD.getRecipientPhoneNumber();
        recipient.setAddressID(addressId);
        recipient.setFirstName(b);
        recipient.setTitle(a);
        recipient.setLastName(c);
        recipient.setEmail(d);
        recipient.setPhoneNumber(e);

        return recipient;
    }

     */

    public Address makeRecipientAddressID(Map<String, Object> userMap){
        Address address = new Address();

        String City = (String) userMap.get("recipientCity");
        String Country = (String) userMap.get("recipientCountry");
        String PostCode = (String) userMap.get("recipientPostCode");
        String AddressLine1 = (String) userMap.get("recipientAddress");
        String Latitude = (String)userMap.get("recipientLatitude");
        String Longitude = (String)userMap.get("recipientLongitude");

        address.setAddressLine1(AddressLine1);
        address.setCity(City);
        address.setCountry(Country);
        address.setPostCode(PostCode);
        address.setIsDefault(1);
        address.setLatitude(Double.parseDouble(Latitude));
        address.setLongitude(Double.parseDouble(Longitude));
        address.setAddressTypeID(1);
        return address;
    }
    /*public Address makeRecipientAddressID(orderDetails orderD){
        Address address = new Address();
        String AddressLine = orderD.getAddressLine1();
        String City = orderD.getCity();
        String Country = orderD.getCountry();
        String Post = orderD.getPostCode();
        address.setAddressLine1(AddressLine);
        address.setCity(City);
        address.setCountry(Country);
        address.setPostCode(Post);
        address.setIsDefault(1);
        address.setLatitude(0.00);
        address.setLongitude(0.00);
        address.setAddressTypeID(1);
        return address;
    }

     */
   /* public User makeUserId(String firstName,String lastName,String email,String password){
        User user= new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(password);
        user.setEmail(email);
        return user;



    }

    */
 //   public static double distance(double lat1, double lat2, double lon1, double lon2, double el1, double el2)

        public double distance(Map<String, Object> userMap) {

        final int R = 6371;
        if (userMap.get("pLat")==null){
        String latitude2 = (String)userMap.get("recipientLatitude");
        String longitude2 = (String)userMap.get("recipientLongitude");
        String latitude1 = (String)userMap.get("customerLatitude");
        String longitude1 = (String)userMap.get("customerLongitude");
        double lat1=Double.parseDouble(latitude1);
        double lat2=Double.parseDouble(latitude2);
        double lon1=Double.parseDouble(longitude1);
        double lon2=Double.parseDouble(longitude2);

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c;


        distance = Math.pow(distance, 2) ;

        return Math.sqrt(distance);}
        else {
            String latitude2 = (String)userMap.get("recipientLatitude");
            String longitude2 = (String)userMap.get("recipientLongitude");
            String latitude1 = (String)userMap.get("pLat");
            String longitude1 = (String)userMap.get("pLon");
            double lat1=Double.parseDouble(latitude1);
            double lat2=Double.parseDouble(latitude2);
            double lon1=Double.parseDouble(longitude1);
            double lon2=Double.parseDouble(longitude2);

            double latDistance = Math.toRadians(lat2 - lat1);
            double lonDistance = Math.toRadians(lon2 - lon1);
            double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                    + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                    * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
            double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
            double distance = R * c ;


            distance = Math.pow(distance, 2) ;

            return Math.sqrt(distance);
        }
    }

    public int calculateFee(double Distance)
    {
        int x;
        int baseFare = 299;
        int weightRate = 350;
        double distanceCovered = Distance * 35;
        x = baseFare + weightRate + (int) distanceCovered;
        return x;
    }

    public Address makePickupAddressID(Map<String, Object> userMap){
        Address address = new Address();

        String CustomerAddressline1 = (String) userMap.get("customerAddress");
        String CustomerCity = (String) userMap.get("customerCity");
        String CustomerCountry = (String) userMap.get("customerCountry");
        String CustomerPostCode = (String) userMap.get("customerPostCode");
        String Latitude = (String)userMap.get("customerLatitude");
        String Longitude = (String)userMap.get("customerLongitude");

        address.setAddressLine1(CustomerAddressline1);
        address.setCity(CustomerCity);
        address.setCountry(CustomerCountry);
        address.setPostCode(CustomerPostCode);
        address.setIsDefault(1);
        address.setLatitude(Double.parseDouble(Latitude));
        address.setLongitude(Double.parseDouble(Longitude));
        address.setAddressTypeID(1);
        return address;
    }
    public CustomerAddress makeCustomerAddressID(int cid, int pid){
        CustomerAddress customerAddress = new CustomerAddress();
        customerAddress.setAddressID(pid);
        customerAddress.setCustomerID(cid);
        customerAddress.setIsCurrent(1);
        return customerAddress;
    }

    public int getCidAddress(Map<String, Object> userMap) throws SQLException {
        int id = 0;
        int Cid = (int) userMap.get("customerID");


        SQLUtilities.Connect();
        String sql = "SELECT [AddressID]"+
                " FROM [ParcelMessenger].[dbo].[CustomerAddress]" +
                "Where [CustomerID]= ?";
        PreparedStatement preparedStatement = SQLUtilities.connection.prepareStatement(sql);
        preparedStatement.setInt(1,Cid);
        ResultSet r = SQLUtilities.ExecuteQuery(preparedStatement);
        while (r.next()){
            id = r.getInt(1);}


        return id;
    }
    public double getCidLat(Map<String, Object> userMap) throws SQLException {
        double lat = 0;
        int addressID = (int)userMap.get("AddID");


        SQLUtilities.Connect();
        String sql = "SELECT [Latitude]"+
                " FROM [ParcelMessenger].[dbo].[Address]" +
                "Where [AddressID]= ?";
        PreparedStatement preparedStatement = SQLUtilities.connection.prepareStatement(sql);
        preparedStatement.setInt(1,addressID);
        ResultSet r = SQLUtilities.ExecuteQuery(preparedStatement);
        while (r.next()){
            lat = r.getInt(1);}


        return lat;
    }
    public double getCidLong(Map<String, Object> userMap) throws SQLException {
        double lon = 0;
        int addressID = (int)userMap.get("AddID");


        SQLUtilities.Connect();
        String sql = "SELECT [Longitude]"+
                " FROM [ParcelMessenger].[dbo].[Address]" +
                "Where [AddressID]= ?";
        PreparedStatement preparedStatement = SQLUtilities.connection.prepareStatement(sql);
        preparedStatement.setInt(1,addressID);
        ResultSet r = SQLUtilities.ExecuteQuery(preparedStatement);
        while (r.next()){
            lon = r.getInt(1);}


        return lon;
    }
    /*public Address makePickupAddressID(orderDetails orderD){
        Address address = new Address();
        String AddressLine = orderD.getCustomerAddressline1();
        String City = orderD.getCustomerCity();
        String Country = orderD.getCustomerCountry();
        String Post = orderD.getCustomerPostCode();
        address.setAddressLine1(AddressLine);
        address.setCity(City);
        address.setCountry(Country);
        address.setPostCode(Post);
        address.setIsDefault(1);
        address.setLatitude(0.00);
        address.setLongitude(0.00);
        address.setAddressTypeID(1);
        return address;
    }

     */

    public Order makeOrderID(Map<String, Object> userMap,int rid,int cid,int caddressID, int fee ){
    Order order = new Order();
    String ExpectedPickUpDate = (String) userMap.get("expectedPickUpDate");
    order.setCustomerID(cid);
    order.setRecipientID(rid);
    //order.setOrderNumber(1);
    order.setExpectedDeliveryDate(ExpectedPickUpDate);
    order.setCost(fee);
    order.setStatus(1);
    order.setPickupAddressID(caddressID);
    order.setExpectedPickUpDate(ExpectedPickUpDate);
    order.setOrderRecipientUnreachableID(1);
    
    return order;
    }

    public int getOrderID(int rid, int cid)throws SQLException{
        int id = 0;
        orderDetails orderD;
        SQLUtilities.Connect();
        String sql = "SELECT [OrderID]"+
                " FROM [ParcelMessenger].[dbo].[Order]" +
                "Where [RecipientID]= ?";
        PreparedStatement preparedStatement = SQLUtilities.connection.prepareStatement(sql);
        preparedStatement.setInt(1,rid);
        ResultSet r = SQLUtilities.ExecuteQuery(preparedStatement);
        while (r.next()){
            id = r.getInt(1);}

        return id;
    }

    public int getCustomerID(Map<String, Object> userMap)throws SQLException{
        int id = 0;
        String CustomerFirstName = (String) userMap.get("customerFirstName");
        String CustomerPhoneNumber = (String) userMap.get("customerPhoneNumber");
        String CustomerEmail = (String) userMap.get("customerEmail");


        SQLUtilities.Connect();
        String sql = "SELECT [CustomerID]"+
                " FROM [ParcelMessenger].[dbo].[Customer]" +
                "Where [Email]= ? AND [FirstName] = ? AND [PhoneNumber]=?";
        PreparedStatement preparedStatement = SQLUtilities.connection.prepareStatement(sql);
        preparedStatement.setString(1,CustomerEmail);
        preparedStatement.setString(2,CustomerFirstName);
        preparedStatement.setString(3,CustomerPhoneNumber);
        ResultSet r = SQLUtilities.ExecuteQuery(preparedStatement);
        while (r.next()){
            id = r.getInt(1);}

        return id;
    }
    /* public int getCustomerID(orderDetails orderDetails)throws SQLException{
        int id = 0;
        orderDetails orderD;
        orderD = orderDetails;
        String firstName = orderD.getCustomerFirstName();
        String number =  orderD.getCustomerPhoneNumber();
        String email = orderD.getCustomerEmail();

        SQLUtilities.Connect();
        String sql = "SELECT [CustomerID]"+
                " FROM [ParcelMessenger].[dbo].[Customer]" +
                "Where [Email]= ? AND [FirstName] = ? AND [PhoneNumber]=?";
        PreparedStatement preparedStatement = SQLUtilities.connection.prepareStatement(sql);
        preparedStatement.setString(1,email);
        preparedStatement.setString(2,firstName);
        preparedStatement.setString(3,number);
        ResultSet r = SQLUtilities.ExecuteQuery(preparedStatement);
        while (r.next()){
            id = r.getInt(1);}

        return id;
    }

     */


    /*public int getRecipientID(orderDetails orderDetails) throws SQLException {
        int id = 0;
        orderDetails orderD;
        orderD = orderDetails;
        int addressId = getRecipientAddressID(orderD);
        String firstName = orderD.getRecipientFirstName();
        String number =  orderD.getRecipientPhoneNumber();
        String email = orderD.getRecipientEmail();

        SQLUtilities.Connect();
        String sql = "SELECT [RecipientID]"+
                " FROM [ParcelMessenger].[dbo].[Recipient]" +
                "Where [AddressID]= ?";
        PreparedStatement preparedStatement = SQLUtilities.connection.prepareStatement(sql);
        preparedStatement.setInt(1,addressId);
        ResultSet r = SQLUtilities.ExecuteQuery(preparedStatement);
        while (r.next()){
            id = r.getInt(1);}

        return id;

    }

     */
    public int getRecipientID(Map<String, Object> userMap) throws SQLException {
        int id = 0;

        int addressId = getRecipientAddressID(userMap);





        SQLUtilities.Connect();
        String sql = "SELECT [RecipientID]"+
                " FROM [ParcelMessenger].[dbo].[Recipient]" +
                "Where [AddressID]= ?";
        PreparedStatement preparedStatement = SQLUtilities.connection.prepareStatement(sql);
        preparedStatement.setInt(1,addressId);
        ResultSet r = SQLUtilities.ExecuteQuery(preparedStatement);
        while (r.next()){
            id = r.getInt(1);}

        return id;

    }


    public int getRecipientAddressID(Map<String, Object> userMap)throws SQLException{
        int id = 0;

        String City = (String) userMap.get("recipientCity");
        String Country = (String) userMap.get("recipientCountry");
        String PostCode = (String) userMap.get("recipientPostCode");
        String AddressLine1 = (String) userMap.get("recipientAddress");



        SQLUtilities.Connect();
        String sql = "SELECT [AddressID]"+
                " FROM [ParcelMessenger].[dbo].[Address]" +
                "Where [AddressLine1]= ? AND [City] = ? AND [Country]=?";
        PreparedStatement preparedStatement = SQLUtilities.connection.prepareStatement(sql);
        preparedStatement.setString(1,AddressLine1);
        preparedStatement.setString(2,City);
        preparedStatement.setString(3,Country);
        ResultSet r = SQLUtilities.ExecuteQuery(preparedStatement);
        while (r.next()){
            id = r.getInt(1);}
        return id;
    }
    /*public int getRecipientAddressID(orderDetails orderDetails)throws SQLException{
        int id = 0;
        orderDetails orderD;
        orderD = orderDetails;
        String address = orderD.getAddressLine1();
        String city = orderD.getCity();
        String country = orderD.getCountry();


        SQLUtilities.Connect();
        String sql = "SELECT [AddressID]"+
                " FROM [ParcelMessenger].[dbo].[Address]" +
                "Where [AddressLine1]= ? AND [City] = ? AND [Country]=?";
        PreparedStatement preparedStatement = SQLUtilities.connection.prepareStatement(sql);
        preparedStatement.setString(1,address);
        preparedStatement.setString(2,city);
        preparedStatement.setString(3,country);
        ResultSet r = SQLUtilities.ExecuteQuery(preparedStatement);
        while (r.next()){
            id = r.getInt(1);}
        return id;
    }

     */
    public int getPickupAddressID(Map<String, Object> userMap)throws SQLException{
        int id = 0;
        String CustomerAddressline1 = (String) userMap.get("customerAddress");
        String CustomerCity = (String) userMap.get("customerCity");
        String CustomerCountry = (String) userMap.get("customerCountry");

        SQLUtilities.Connect();
        String sql = "SELECT [AddressID]"+
                " FROM [ParcelMessenger].[dbo].[Address]" +
                "Where [AddressLine1]= ? AND [City] = ? AND [Country]=?";
        PreparedStatement preparedStatement = SQLUtilities.connection.prepareStatement(sql);
        preparedStatement.setString(1,CustomerAddressline1);
        preparedStatement.setString(2,CustomerCity);
        preparedStatement.setString(3,CustomerCountry);
        ResultSet r = SQLUtilities.ExecuteQuery(preparedStatement);
        while (r.next()){
            id = r.getInt(1);}
        return id;
    }
/*    public int getPickupAddressID(orderDetails orderDetails)throws SQLException{
        int id = 0;
        orderDetails orderD;
        orderD = orderDetails;
        String address = orderD.getCustomerAddressline1();
        String city = orderD.getCustomerCity();
        String country = orderD.getCustomerCountry();


        SQLUtilities.Connect();
        String sql = "SELECT [AddressID]"+
                " FROM [ParcelMessenger].[dbo].[Address]" +
                "Where [AddressLine1]= ? AND [City] = ? AND [Country]=?";
        PreparedStatement preparedStatement = SQLUtilities.connection.prepareStatement(sql);
        preparedStatement.setString(1,address);
        preparedStatement.setString(2,city);
        preparedStatement.setString(3,country);
        ResultSet r = SQLUtilities.ExecuteQuery(preparedStatement);
        while (r.next()){
            id = r.getInt(1);}
        return id;
    }


 */

public int adder (int x){
  x= x+10;
  return x;
}

}


