package SystemData;

import DataClasses.Member;

public class MemberDataBase {

    Member[] members = new Member[5];
    String[][] sales = new String [3][1];
    public MemberDataBase() {
        members[0] = new Member("Anacleto", "01", "123456789", );
        members[1] = new Member("Chema", "02");
        members[2] = new Member("Javier", "03");
        members[3] = new Member("Pepe", "04");
        members[4] = new Member("Diego", "05");

        sales[0][0] = "golden";
        sales[0][1] = "10";

        sales[1][0] = "silver";
        sales[1][1] = "5";

        sales[2][0] = "bronze";
        sales[2][1] = "2";
    }







}
