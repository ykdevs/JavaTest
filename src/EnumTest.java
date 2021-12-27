public class EnumTest {

    public void test() {
        // Enum定数からEnumを取得
        Fruit flt10 = Fruit.ORANGE;
        System.out.println("Fruit.ORANGE = " + flt10);

        // 文字列からEnumを取得
        Fruit flt11 = Fruit.valueOf("APPLE");
        System.out.println("Fruit.valueOf(\"APPLE\") = " + flt11);

        // Enum配列番号からEnumを取得
        Fruit flt12 = Fruit.values()[2];
        System.out.println("Fruit.values()[2] = " + flt12.toString());

        // Enum定数からEnumを取得
        Fruit2 flt20 = Fruit2.ORANGE;
        System.out.println("Fruit2.ORANGE = " + flt20);
        System.out.println("Fruit2.ORANGE = " + flt20.getLabel());
        System.out.println("Fruit2.ORANGE = " + flt20.getId());

        // 文字列からEnumを取得
        Fruit2 flt21 = Fruit2.valueOf("APPLE");
        System.out.println("Fruit.valueOf(\"APPLE\") = " + flt21);
        System.out.println("Fruit.valueOf(\"APPLE\") = " + flt21.getLabel());
        System.out.println("Fruit.valueOf(\"APPLE\") = " + flt21.getId());

        // Enum配列番号からEnumを取得
        Fruit2 flt22 = Fruit2.values()[2];
        System.out.println("Fruit.values()[2] = " + flt22.toString());
        System.out.println("Fruit.values()[2] = " + flt22.getLabel());
        System.out.println("Fruit.values()[2] = " + flt22.getId());
    }

    // 単純なEnum
    public enum Fruit {
        //列挙子の定義
        APPLE,
        ORANGE,
        PEACH
    }

    // Label, Id付きEnum
    public enum Fruit2 {

        APPLE("りんご", 1),
        ORANGE("オレンジ", 2),
        PEACH("もも", 3);

        private final String label;
        private final int id;

        Fruit2(String label, int id) {   //コンストラクタはprivateで宣言
            this.label = label;
            this.id = id;
        }

        public String getLabel() {
            return label;
        }

        public int getId() {
            return id;
        }
    }
}
