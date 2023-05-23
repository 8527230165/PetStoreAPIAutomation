package api.endpoints;

public class Routes {
	
	public static String base_url="https://petstore.swagger.io/v2";
	
	//User Model
	public static String user_post_url=base_url+"/user";
	public static String user_get_url=base_url+"/user/{username}";
	public static String user_delete_url=base_url+"/user/{username}";
	public static String user_update_url=base_url+"/user/{username}";
	
	//Pet Model
	public static String pet_post_url=base_url+"/pet";
	public static String pet_get_url=base_url+"/pet/{petid}";
	public static String pet_delete_url=base_url+"/pet/{petid}";
	public static String pet_update_url=base_url+"/pet";
	
	//Store Model
	public static String store_post_url=base_url+"/store/order";
	public static String store_get_url=base_url+"/store/order{orderid}";
	public static String store_delete_url=base_url+"/store/order{orderid}";
	
}
