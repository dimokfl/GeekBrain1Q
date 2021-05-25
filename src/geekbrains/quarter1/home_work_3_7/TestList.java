package geekbrains.quarter1.home_work_3_7;

public class TestList {

    @BeforeSuite
    public int prepareTest(){
        return 0;
    }

    @AfterSuite
    public int cleanupTest(){
        return 0;
    }

    @Test
    public int testMethod1(){
        return 1;
    }

    @Test(priority = 2)
    public int testMethod2(){
        return 2;
    }

    @Test(priority = 3)
    public int testMethod3(){
        return 3;
    }

}
