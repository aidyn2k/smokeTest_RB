import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

@Owner("aidyn2k")
public class SmokeTest extends TestBase{

    @Test
    @Feature("Проверка отображения главных разделов")
    @Story("Открытие главной")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка отображения Главной страницы")
    @Link(name = "RB", url = "http://rahmetbiz.chocodev.kz/")
    public void mainPageDisplay() {
        step("Отображение фильтра Даты", () -> {
            $(".main-page__filters.d-none.d-md-flex > div:nth-child(2)").shouldBe(visible);
        });
        step("Отображение фильтра Филиалов", () -> {
            $(".main-page__filters.d-none.d-md-flex > div:nth-child(3)").shouldBe(visible);
        });
        step("Цвет иконки Главная активная", () -> {
            $("li.active > a > div > img.main-menu__image--active").shouldBe(visible);
        });
    }

    @Test
    @DisplayName("Проверка отображения подраздела Транзакции")
    public void cashboxTransactionSectionDisplay() {
        step("Переход в подраздел Транзакции", () -> {
            $(".main-menu").find(byText("Касса")).click();
            $(".sub-menu").find(byText("Транзакции")).click();
        });
        step("Отображение фильтра Заказов", () -> {
            $(".filter-search > div > button").shouldBe(visible);
        });
        step("Отображение фильтра Даты", () -> {
            $(".vue-daterange-picker.mr-3.date-selector > div").shouldBe(visible);
        });
        step("Отображение фильтра Филиалов", () -> {
            $("div:nth-child(4) > button").shouldBe(visible);
        });
        step("Отображение фильтра Видов операции", () -> {
            $("div:nth-child(5) > button").shouldBe(visible);

        });
        step("Цвет иконки Касса активная", () -> {
            $("li.active > a > div > img.main-menu__image--active").shouldBe(visible);
        });
    }

    @Test
    @DisplayName("Проверка отображения подраздела Онлайн-заказы")
    public void cashboxOnlineOrdersSectionDisplay() {
        step("Переход в подраздел Онлайн-заказы", () -> {
            $(".main-menu").find(byText("Касса")).click();
            $(".sub-menu").find(byText("Онлайн-заказы")).click();
        });
        step("Отображение фильтра Заказов", () -> {
            $(".filter-search > div > button").shouldBe(visible);
        });
        step("Отображение фильтра Филиалов", () -> {
            $(".filter-row.d-flex > div.filter-multi-select.mr-3 > button").shouldBe(visible);
        });
        step("Цвет иконки Касса активная", () -> {
            $("li.active > a > div > img.main-menu__image--active").shouldBe(visible);
        });
    }

    @Test
    @DisplayName("Проверка отображения раздела Отчеты")
    public void reportsSectionDisplay() {
        step("Переход в раздел Отчеты", () -> {
            $(".main-menu").find(byText("Отчеты")).click();
        });
        step("Отображение фильтра Филиалов", () -> {
            $(".filter-multi-select.mr-3 > button").shouldBe(visible);
        });
        step("Отображение фильтра Даты", () -> {
            $(".vue-daterange-picker.mr-3.date-selector > div").shouldBe(visible);
        });
        step("Цвет иконки Отчеты активная", () -> {
            $("li.active > a > div > img.main-menu__image--active").shouldBe(visible);
        });
    }

    @Test
    @DisplayName("Проверка отображения подраздела Отзывы")
    public void reviewsSectionDisplay() {
        step("Переход в подраздел Отзывы", () -> {
            $(".main-menu").find(byText("Работа с клиентами")).click();
            $(".sub-menu").find(byText("Отзывы")).click();
        });
        step("Отображение фильтра Даты", () -> {
            $(".vue-daterange-picker.mr-3 > div").shouldBe(visible);
        });
        step("Отображение фильтра Филиалов", () -> {
            $("div:nth-child(3) > button").shouldBe(visible);
        });
        step("Отображение фильтра Статусов", () -> {
            $("div:nth-child(4) > button").shouldBe(visible);
        });
        step("Отображение фильтра Оценок", () -> {
            $("div:nth-child(5) > button").shouldBe(visible);
        });
        step("Отображение фильтра Видов отзыва", () -> {
            $("div:nth-child(6) > button").shouldBe(visible);
        });
        step("Цвет иконки Работа с клиентами активная", () -> {
            $("li.active > a > div > img.main-menu__image--active").shouldBe(visible);
        });
    }

    @Test
    @DisplayName("Проверка отображения подраздела Клиенты")
    public void clientsSectionDisplay() {
        step("Переход в подраздел Клиенты", () -> {
            $(".main-menu").find(byText("Работа с клиентами")).click();
            $(".sub-menu").find(byText("Клиенты")).click();
        });
        step("Отображение фильтра Филиалов", () -> {
            $("#customersList button").shouldBe(visible);
        });
        step("Отображение фильтра Даты", () -> {
            $("#customersList > div.vue-daterange-picker.mr-3 > div").shouldBe(visible);
        });
        step("Цвет иконки Работа с клиентами активная", () -> {
            $("li.active > a > div > img.main-menu__image--active").shouldBe(visible);
        });
    }

    @Test
    @DisplayName("Проверка отображения подраздела Финансовые показатели")
    public void financeSectionDisplay() {
        step("Переход в подраздел Финансовые показатели", () -> {
            $(".main-menu").find(byText("Аналитика")).click();
            $(".sub-menu").find(byText("Финансовые показатели")).click();
        });
        step("Отображение фильтра Филиалов", () -> {
            $(".filter-multi-select.mr-3 button").shouldBe(visible);
        });
        step("Цвет иконки Аналитика активная", () -> {
            $("li.active > a > div > img.main-menu__image--active").shouldBe(visible);
        });
    }

    @Test
    @DisplayName("Проверка отображения подраздела Рейтинг и отзывы")
    public void ratingAndReviewsSectionDisplay() {
        step("Переход в подраздел Рейтинг и отзывы", () -> {
            $(".main-menu").find(byText("Аналитика")).click();
            $(".sub-menu").find(byText("Рейтинг и отзывы")).click();
        });
        step("Отображение фильтра Филиалов", () -> {
            $(".filter-multi-select.mr-3 button").shouldBe(visible);
        });
        step("Цвет иконки Аналитика активная", () -> {
            $("li.active > a > div > img.main-menu__image--active").shouldBe(visible);
        });
    }

    @Test
    @DisplayName("Проверка отображения раздела Сотрудники")
    public void employeesSectionDisplay() {
        step("Переход в раздел Сотрудники", () -> {
            $(".main-menu").find(byText("Сотрудники")).click();
        });
        step("Отображение фильтра Филиалов", () -> {
            $(".filter-multi-select.mr-3 button").shouldBe(visible);
        });
        step("Цвет иконки Сотрудники активная", () -> {
            $("li.active > a > div > img.main-menu__image--active").shouldBe(visible);
        });
    }

    @Test
    @DisplayName("Проверка выгрузки отчета Excel в разделе Касса - Транзакций")
    public void reportDownloadInCashboxTest() {
        step("Переход в подраздел Транзакции", () -> {
            $(".main-menu").find(byText("Касса")).click();
            $(".sub-menu").find(byText("Транзакции")).click();
        });
        step("Выбрать Выгрузить отчет в Excel", () -> {
            $("button.reports-excel-btn").click();
        });
        step("Нажать на инпут выбора периода", () -> {
            $(".range-input").click();
        });
        step("Выбрать последние 7 дней", () -> {
            $("div.calendars.row.no-gutters").find((byText("Последние 7 дней"))).click();
        });
        step("Нажать Выбрать", () -> {
            $("button.applyBtn.btn.btn-sm.btn-success").click();
        });
        step("Выбрать фильтр филиалов", () -> {
            $("button.multi-select-button.multi-select-btn-square").click();
        });
        step("Выбрать параметр Все филиалы", () -> {
            $(".multi-select-dropdown").find((byText("Все филиалы"))).click();
        });
        step("Нажать Применить", () -> {
            $(".multi-select-dropdown").find((byText("Применить"))).click();
        });
        step("Нажать Выгрузить", () -> {
            $("button.btn.btn-primary.btn-block.btn-multiple-state").click();
        });
    }

    @Test
    @DisplayName("Проверка выгрузки отчета Excel в разделе Отчеты")
    public void reportDownloadInReportsTest() {
        step("Переход в раздел Отчеты", () -> {
            $(".main-menu").find(byText("Отчеты")).click();
        });
        step("Выбрать Выгрузить отчет в Excel", () -> {
            $("button.reports-excel-btn").click();
        });
        step("Нажать на инпут выбора периода", () -> {
            $(".range-input").click();
        });
        step("Выбрать последние 7 дней", () -> {
            $("div.calendars.row.no-gutters").find((byText("Последние 7 дней"))).click();
        });
        step("Нажать Выбрать", () -> {
            $("button.applyBtn.btn.btn-sm.btn-success").click();
        });
        step("Выбрать фильтр филиалов", () -> {
            $("button.multi-select-button.multi-select-btn-square").click();
        });
        step("Выбрать параметр Все филиалы", () -> {
            $(".multi-select-dropdown").find((byText("Все филиалы"))).click();
        });
        step("Нажать Применить", () -> {
            $(".multi-select-dropdown").find((byText("Применить"))).click();
        });
        step("Нажать Выгрузить", () -> {
            $("button.btn.btn-primary.btn-block.btn-multiple-state").click();
        });
    }
}
