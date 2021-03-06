package regEx;

public class Main_ReplaceWords_String {

    public static void main(String[] args) {
        Address ave = new Address("555 Straight Stave Ave","San Francisco");
        Address st = new Address("444 Ave Maria Stairway St.","San Francisco");
        Address str = new Address("9032 Flave Steep Str","San Francisco");

        Address[] addr = {ave,st,str};

        addressCleanup(addr);
        /*String ave = "555 Straight Stave Ave, San Francisco, CA 94104";
        String st = "444 Ave Maria Stairway St., San Francisco, CA 94104";
        String str = "9032 Flave Steep Str, San Francisco, CA 94104";

        System.out.println("Input data : ");
        System.out.println(ave);
        System.out.println(st);
        System.out.println(str);

        String replaceAve = ave.replaceAll("Ave", "Avenue");
        String replaceSt = st.replaceAll("St\\.", "Street");
        String replaceStr = str.replaceAll("Str", "Street");

        System.out.println("\nResult : ");
        System.out.println(replaceAve);
        System.out.println(replaceSt);
        System.out.println(replaceStr);*/
    }

    public static void addressCleanup(Address[] addresses){
        String first;

        for (Address address : addresses) {
            if (address.street.endsWith("Ave")) {
                first = address.street.replaceFirst("Ave", "Avenue");
                System.out.println(first);
            } else if(address.street.endsWith("Ave.")){
                first = address.street.replaceFirst("Ave\\.", "Avenue");
                System.out.println(first);
            }
            if (address.street.endsWith("St")) {
                first = address.street.replaceFirst("St", "Street");
                System.out.println(first);
            } else if(address.street.endsWith("St.")){
                first = address.street.replaceFirst("St\\.", "Street");
                System.out.println(first);
            }
            if (address.street.endsWith("Str")) {
                first = address.street.replaceFirst("Str", "Street");
                System.out.println(first);
            } else if(address.street.endsWith("Str.")){
                first = address.street.replaceFirst("Str\\.", "Street");
                System.out.println(first);
            }
        }
    }
}