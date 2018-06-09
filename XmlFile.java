package test.task2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.Node;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XmlFile {
    File fXml = null;
    Document doc;

    public XmlFile() {
        try {
            fXml = new File("list.xml");
        }
        catch (Exception ei) {
            System.out.println("Не удалось найти файл");
            System.exit(0);
        }
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse(fXml);
            doc.getDocumentElement().normalize();
        }
        catch (Exception ei) {
            System.out.println("Не удалось прочитать файл");
            System.exit(0);
        }
    }
    public ArrayList read() {
        ArrayList<Task> taskList = new ArrayList<>();
        NodeList tasks = null;
        try {
            tasks = doc.getElementsByTagName("Task");
        }
        catch (Exception ei) {
            System.out.println("Не удалось найти теги 'Task'");
            System.exit(0);
        }
        for (int i = 0; i < tasks.getLength(); i++) {
            Element currTask = (Element) tasks.item(i);
            Task newTask = new Task();

            String id = currTask.getAttributes().getNamedItem("id").getNodeValue();
            newTask.setId(id);
            String title = currTask.getAttributes().getNamedItem("caption").getNodeValue();
            newTask.setTitle(title);
            String description = currTask.getElementsByTagName("Description").item(0).getTextContent();
            newTask.setDescription(description);
            String priority = currTask.getElementsByTagName("Priority").item(0).getTextContent();
            newTask.setPriority(priority);
            String deadline = currTask.getElementsByTagName("Deadline").item(0).getTextContent();
            newTask.setDeadline(deadline);
            String status = currTask.getElementsByTagName("Status").item(0).getTextContent();
            newTask.setStatus(Status.valueOf(status.toUpperCase()));
            String complete = currTask.getElementsByTagName("Complete").item(0).getTextContent();
            newTask.setComplete(complete);
            taskList.add(newTask);
        }
        return taskList;

    }

    public void write(List<Task> taskList) {
        NodeList tasks = doc.getElementsByTagName("ToDoList");
        NodeList removeTasks = doc.getElementsByTagName("Task");

        int n = removeTasks.getLength() - 1;
        for (int i = n; i >= 0; i--) {
            tasks.item(0).removeChild(removeTasks.item(i));
        }
        for (int i = 0; i < taskList.size(); i++) {
            Element newTask = doc.createElement("Task");
            Task task = (Task) taskList.get(i);
            newTask.setAttribute("caption", task.getTitle());
            newTask.setAttribute("id", task.getId());
            Element newDescriprion = (Element) doc.createElement("Description");
            newDescriprion.setTextContent(task.getDescription());
            newTask.appendChild(newDescriprion);
            Element newPriority = doc.createElement("Priority");
            newPriority.setTextContent(task.getPriority());
            newTask.appendChild(newPriority);
            Element newDeadline = doc.createElement("Deadline");
            newDeadline.setTextContent(task.getDeadline());
            newTask.appendChild(newDeadline);
            Element newStatus = doc.createElement("Status");
            newStatus.setTextContent(task.getStatus().toString());
            newTask.appendChild(newStatus);
            Element newComplete = doc.createElement("Complete");
            newComplete.setTextContent(task.getComplete());
            newTask.appendChild(newComplete);
            tasks.item(0).appendChild(newTask);
        }
        try {
            doc.getDocumentElement().normalize();
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("list.xml"));
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);
            System.out.println("XML успешно изменен!");
        }
        catch (Exception ei) {
            System.out.println("Не удалось изменить файл");
        }

    }
}
