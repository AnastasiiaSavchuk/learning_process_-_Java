import service.ProjectService;
import service.TeamLeadService;
import service.TeamLeadWorkerService;
import service.WorkerService;
import service.impl.ProjectServiceImpl;
import service.impl.TeamLeadServiceImpl;
import service.impl.TeamLeadWorkerServiceImpl;
import service.impl.WorkerServiceImpl;


public class Main {

    private static ProjectService projectService = new ProjectServiceImpl();
    private static TeamLeadService teamLeadService = new TeamLeadServiceImpl();
    private static WorkerService workerService = new WorkerServiceImpl();
    private static TeamLeadWorkerService teamLeadWorkerService = new TeamLeadWorkerServiceImpl();

    public static void main(String[] args) {

        projectService.readAll().forEach(System.out::println);
        //System.out.println(projectService.readById(0));
        //System.out.println(projectService.getByEmail("test@gmail.com"));
        //projectService.create(new Project(1,"client", "E-Magazine", 26984, "EM@gmail.com","123456em" ));
        //projectService.delete(1);

        //teamLeadService.readAll().forEach(System.out::println);
        //System.out.println(teamLeadService.readById(0));
        //teamLeadService.create(new TeamLead(1897299425,"tl", "1970-01-01", 26984));
        //teamLeadService.delete(1897299425);

        //workerService.readAll().forEach(System.out::println);
        //System.out.println(workerService.readById(0));
        //System.out.println(workerService.readByData("Dima"));
        //workerService.create(new Worker(1,"name", "title", 269));
        //workerService.delete(1);

        //teamLeadWorkerService.readAll().forEach(System.out::println);
        //System.out.println(teamLeadWorkerService.readByIds(0,0));
        //teamLeadWorkerService.create(1845530098,1414706622,1);
        //teamLeadWorkerService.delete(1845530098,1414706622);
    }
}
