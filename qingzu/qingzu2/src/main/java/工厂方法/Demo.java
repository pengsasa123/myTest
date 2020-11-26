package 工厂方法;

public class Demo {

    private static Dialog dialog;

    static void configure() {
        if(System.getProperty("os.name").equals("Windows 7")){
            dialog = new WindowsDialog();
        }else {
            dialog = new HtmlDialog();
        }
    }

    static void runBusinesLogic() {
        dialog.renderWindow();
    }

    public static void main(String[] args) {
        configure();
        runBusinesLogic();
    }
}
