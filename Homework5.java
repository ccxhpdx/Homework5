public interface ReadingMatterInte {
    //接口里面的成员变量不能被改变（public static final）
    int price = 50;             //价格
    int pagination = 200;       //页数

    //作用
    public void Effect();
    //适合对象
    public void FitObject();

}

//实现接口类
public class ReadingMatterImpl implements ReadingMatterInte {

    //实现接口的两个方法
    @Override
    public void Effect() {
        System.out.println("(父类)可以阅读的！！");
    }

    @Override
    public void FitObject() {
        System.out.println("(父类)任何阶段的人都能读书");
    }

    //价格与页数的get方法
    public int getPrice() {
        return price;
    }

    public int getPagination() {
        return pagination;
    }

}

//课本，继承了接口的实现类
public class TextBook extends ReadingMatterImpl {

    String name = "课本";

    //覆盖父类的两个方法
    @Override
    public void Effect() {
        System.out.println("课本是用来学习的！");
    }
    @Override
    public void FitObject() {
        System.out.println("课本最适合的使用对象是学生");
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "课本 ：" +  "价格 = " + price + " , 页数 = " + pagination;
    }
}

//期刊
public class Periodical extends ReadingMatterImpl {
    String name = "期刊";
    //出版周期
    String date = "7 day";

    //覆盖父类方法
    @Override
    public void Effect() {
        System.out.println("期刊...");
    }
    //返回该类描述的读物
    public String getName() {
        return name;
    }
    //返回杂志的出版周期
    public String getDate() {
        return date;
    }

    //重写toString方法
    public String toString() {
        return "期刊：" +  "价格 = " + price + " , 页数 = " + pagination + " , 出版周期 = " + date;
    }
}

//杂志，继承了接口的实现类
public class Magazine extends ReadingMatterImpl {
    String name = "杂志";
    //出版周期
    String date = "30 day";

    //覆盖父类方法
    @Override
    public void Effect() {
        System.out.println("这是继承了读物类的杂志类");
    }
    //返回该类描述的读物
    public String getName() {
        return name;
    }
    //返回杂志的出版周期
    public String getDate() {
        return date;
    }

    //重写toString方法
    public String toString() {
        return "杂志：" +  "价格 = " + price + " , 页数 = " + pagination + " , 出版周期 = " + date;
    }
}

//小说，继承了接口的实现类
public class Fiction extends ReadingMatterImpl {

    String name = "小说";

    //覆盖父类方法
    @Override
    public void Effect() {
        //调用父类方法
        super.Effect();
        System.out.println( "小说有很多种类型，喜欢看的人很多" );
    }

    //小说的阅读方式
    public void ReadingMode(){
        System.out.println("可以通过手机看，也可以看书");
    }

    //返回该类描述的读物
    public String getName() {
        return name;
    }

    //重写toString方法
    @Override
    public String toString() {
        return "小说 ：" +  "价格 = " + price + " , 页数 = " + pagination;
    }
}

//主函数
public class Main {
    public static void main(String[] args) {
        //创建四个类的对象
        Fiction fiction = new Fiction();
        Magazine magazine = new Magazine();
        TextBook textBook = new TextBook();
        Periodical periodical = new Periodical();

        //测试：
        System.out.println("小说：");
        //这里调用Effect时又调用了父类的Effext方法
        fiction.Effect();
        fiction.ReadingMode();
        System.out.println(fiction.toString());
        //父类的方法
        fiction.FitObject();

        System.out.println("\n杂志：");
        magazine.Effect();
        System.out.println(magazine.toString());

        System.out.println("\n期刊：");
        periodical.Effect();
        System.out.println(periodical.toString());

        System.out.println("\n课本：");
        textBook.Effect();
        textBook.FitObject();
        System.out.println(textBook.toString());
    }
}
