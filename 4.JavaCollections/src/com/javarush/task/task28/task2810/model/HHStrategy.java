package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HHStrategy implements Strategy {

  private static final String URL_FORMAT = "http://hh.ru/search/vacancy?text=java+%s&page=%d";
  //private static final String TEST_URL = "http://javarush.ru/testdata/big28data.html";

  @Override
  public List<Vacancy> getVacancies(String searchString) {
    List<Vacancy> vacancies = new ArrayList<>();
    String siteName = "http://hh.ru";

    for (int i = 0; ; i++) {
      try {
        Document doc = getDocument(searchString, i);

        Elements elements = doc.select("[data-qa=vacancy-serp__vacancy]");

        if (elements.size() == 0) {
          break;
        } else {

          for (Element element :
              elements) {
            Vacancy vacancy = new Vacancy();

            vacancy.setSiteName(siteName);
            vacancy
                .setCity(element.select("[data-qa=vacancy-serp__vacancy-address").text());
            vacancy
                .setCompanyName(
                    element.select("[data-qa=vacancy-serp__vacancy-employer").text());
            try {
              vacancy.setSalary(
                  element.select("[data-qa=vacancy-serp__vacancy-compensation]").text());
            } catch (NullPointerException e) {
              vacancy.setSalary("");
            }
            vacancy
                .setTitle(element.select("[data-qa=vacancy-serp__vacancy-title]").text());
            vacancy.setUrl(
                element.select("[data-qa=vacancy-serp__vacancy-title]").attr("href"));
            vacancies.add(vacancy);
          }
        }

      } catch (IOException e) {
        break;
      }
    }

    return vacancies;
  }

  protected Document getDocument(String searchString, int page) throws IOException {
    Document doc = Jsoup.connect(String.format(URL_FORMAT, searchString, page)).userAgent(
        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.125 Safari/537.36")
        .referrer("no-referrer-when-downgrade")
        .get();

    return doc;
  }


}
