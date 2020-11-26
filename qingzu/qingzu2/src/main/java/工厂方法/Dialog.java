package 工厂方法;

/**
 * 基础创建者
 */
public abstract class Dialog {

    public void renderWindow() {
        Button button = createButton();
        button.render();
    }

    public abstract Button createButton();
}


class HtmlDialog extends Dialog {

    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}


class WindowsDialog extends Dialog {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}