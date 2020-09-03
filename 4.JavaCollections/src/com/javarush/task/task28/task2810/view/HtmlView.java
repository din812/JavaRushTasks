package com.javarush.task.task28.task2810.view;

import com.javarush.task.task28.task2810.Controller;
import com.javarush.task.task28.task2810.vo.Vacancy;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlView implements View {

  private Controller controller;
  private final String filePath = "./4.JavaCollections/src/"
      + this.getClass().getPackage().getName().replace('.', '/') + "/vacancies.html";

  @Override
  public void update(List<Vacancy> vacancies) {
    System.out.println(filePath);
    try {
      updateFile(getUpdatedFileContent(vacancies));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void setController(Controller controller) {
    this.controller = controller;
  }

  public void userCitySelectEmulationMethod() {
    controller.onCitySelect("Odessa");
  }

  private String getUpdatedFileContent(List<Vacancy> vacancies) {
    String fileContent = null;

      try {
        Document doc = getDocument();
        Element templateElement = doc.getElementsByClass("template").first();

        Element patternElement = templateElement.clone();
        patternElement.removeAttr("style");
        patternElement.removeClass("template");

        doc.select("[class=vacancy]").remove();

        for (Vacancy vacancy : vacancies) {
          Element newVacancyElement = patternElement.clone();
          newVacancyElement.getElementsByClass("city").first().text(vacancy.getCity());
          newVacancyElement.getElementsByClass("companyName").first().text(vacancy.getCompanyName());
          newVacancyElement.getElementsByClass("salary").first().text(vacancy.getSalary());
          Element link = newVacancyElement.getElementsByTag("a").first();
          link.text(vacancy.getTitle());
          link.attr("href", vacancy.getUrl());

          templateElement.before(newVacancyElement.outerHtml());
        }

        fileContent = doc.html();

      } catch (IOException e) {
        e.printStackTrace();
        return "Some exception occurred";
      }

    return fileContent;
  }

  protected Document getDocument() throws IOException {
    return Jsoup.parse(new File(filePath), "UTF-8");
  }

  private void updateFile(String str) {
    try {
      BufferedWriter fWriter = new BufferedWriter(new FileWriter(filePath));
      fWriter.write(str);
      fWriter.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
