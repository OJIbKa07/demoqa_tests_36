package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {


    public void setDate(String day, String month, String year) {
        SelenideElement monthSelect = $(".react-datepicker__month-select"),
                        yearSelect = $(".react-datepicker__year-select"),
                        daySelect = $(".react-datepicker__day--0" + day);

        monthSelect.selectOption(month);
        yearSelect.selectOption(year);
        daySelect.click();
    }
}
