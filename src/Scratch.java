public class Scratch
{
    public static void main(String[] args)
    {
        ApiService apiService = new ApiService();
        String response = apiService.getResponse("Jason");
        String[] events = response.split("},\\{");

        String str = events[0];
//        System.out.println(events[0]);


//        for(String str: events)
//        {
//            System.out.println(str);
//            System.out.println("=============================================");
//        }
//
//        System.out.println(events.length);



    }
}
