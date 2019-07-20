/**
 * @Classname Test
 * @Description 所有Counter的父类，决定io方式
 * @Date 7/16/2019 3:41 PM
 * @Created by MichaelCS
 */
public class Counter {
    protected String ioMethod = null;
    public void chooseIoMethod(String ioMethod){
        this.ioMethod = ioMethod;
    }
}
