package com.javarush.task.task32.task3209;

import java.io.*;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

public class Controller {

  private View view;
  private HTMLDocument document;
  private File currentFile;

  public Controller(View view) {
    this.view = view;
  }

  public static void main(String[] args) {
    View view = new View();
    Controller controller = new Controller(view);
    view.setController(controller);
    view.init();
    controller.init();
  }

  public HTMLDocument getDocument() {
    return document;
  }

  public void resetDocument() {
    if (document != null) {
      document.removeUndoableEditListener(view.getUndoListener());
    }
    document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
    document.addUndoableEditListener(view.getUndoListener());
    view.update();
  }

  public String getPlainText() {
    try {
      StringWriter stringWriter = new StringWriter();
      new HTMLEditorKit().write(stringWriter, document, 0, document.getLength());
      stringWriter.flush();
      return stringWriter.toString();
    } catch (Exception e) {
      ExceptionHandler.log(e);
    }
    return null;
  }

  public void setPlainText(String text) {
    resetDocument();
    StringReader stringReader = new StringReader(text);
    try {
      new HTMLEditorKit().read(stringReader, document, 0);
    } catch (IOException | BadLocationException e) {
      ExceptionHandler.log(e);
    }
  }

  public void createNewDocument() {
    view.selectHtmlTab();
    resetDocument();
    view.setTitle("HTML редактор");
    view.resetUndo();
    currentFile = null;
  }

  public void openDocument() {
    view.selectHtmlTab();
    JFileChooser jFileChooser = new JFileChooser();
    jFileChooser.setFileFilter(new HTMLFileFilter());
    jFileChooser.setApproveButtonText("Open File");
    if (jFileChooser.showOpenDialog(view) == JFileChooser.APPROVE_OPTION) {
      currentFile = jFileChooser.getSelectedFile();
      this.resetDocument();
      view.setTitle(currentFile.getName());
      try {
        FileReader fr = new FileReader(currentFile);
        new HTMLEditorKit().read(fr, document, 0);
        fr.close();
        view.resetUndo();
      } catch (IOException | BadLocationException e) {
        ExceptionHandler.log(e);
      }
    }
  }

  public void saveDocument() {
    if (currentFile == null) {
      saveDocumentAs();
    } else {
      view.selectHtmlTab();
      try {
        FileWriter fw = new FileWriter(currentFile);
        new HTMLEditorKit().write(fw, document, 0, document.getLength());
        fw.flush();
      } catch (IOException | BadLocationException e) {
        ExceptionHandler.log(e);
      }
    }
  }

  public void saveDocumentAs() {
    view.selectHtmlTab();
    JFileChooser jFileChooser = new JFileChooser();
    jFileChooser.setFileFilter(new HTMLFileFilter());
    jFileChooser.setApproveButtonText("Save File");
    if (jFileChooser.showSaveDialog(view) == JFileChooser.APPROVE_OPTION) {
      currentFile = jFileChooser.getSelectedFile();
      view.setTitle(currentFile.getName());
      try {
        FileWriter fw = new FileWriter(currentFile);
        new HTMLEditorKit().write(fw, document, 0, document.getLength());
        fw.flush();
      } catch (IOException | BadLocationException e) {
        ExceptionHandler.log(e);
      }
    }
  }

  //инициализация
  public void init() {
    createNewDocument();
  }

  //закрытие программы
  public void exit() {
    System.exit(0);
  }
}
