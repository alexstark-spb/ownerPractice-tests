package com.alexstark;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;

public class GithubTest extends TestBase {

    @Test
    public void findGithubRepository() {
        open(TestData.BASE_URL);
        $(byName("q")).val(TestData.GITHUB_PROFILE).pressEnter();
        $$("ul.repo-list li").first().$("a").click();
        $("h1").shouldHave(text(TestData.REPOSITORY));
    }
}