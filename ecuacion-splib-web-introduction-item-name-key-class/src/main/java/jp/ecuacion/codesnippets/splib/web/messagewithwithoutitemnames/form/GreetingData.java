package jp.ecuacion.codesnippets.splib.web.messagewithwithoutitemnames.form;

import jp.ecuacion.lib.core.annotation.ItemNameKeyClass;
import jp.ecuacion.splib.web.item.HtmlItem;
import jp.ecuacion.splib.web.item.HtmlItemContainer;

@ItemNameKeyClass("greeting")
public class GreetingData implements HtmlItemContainer {

    private String name;

    @Override
    public HtmlItem[] customizedItems() {
        return new HtmlItem[] {
            new HtmlItem("name").notEmpty()
        };
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
