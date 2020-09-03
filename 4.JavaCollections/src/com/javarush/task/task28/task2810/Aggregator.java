package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.HHStrategy;
import com.javarush.task.task28.task2810.model.Model;
import com.javarush.task.task28.task2810.model.MoikrugStrategy;
import com.javarush.task.task28.task2810.model.Provider;
import com.javarush.task.task28.task2810.model.Strategy;
import com.javarush.task.task28.task2810.view.HtmlView;
import com.javarush.task.task28.task2810.view.View;
import com.javarush.task.task28.task2810.vo.Vacancy;
import java.util.List;

public class Aggregator {

  public static void main(String[] args) {
    HtmlView view = new HtmlView();
    Provider providerHH = new Provider(new HHStrategy());
    Provider providerMS = new Provider(new MoikrugStrategy());
    Model model = new Model(view, new Provider[] {providerHH, providerMS});

    view.setController(new Controller(model));
    view.userCitySelectEmulationMethod();
  }
}
