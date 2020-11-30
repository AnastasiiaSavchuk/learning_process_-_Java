import exception.AlreadyExistException;
import exception.NotFoundException;
import service.impl.ProjectServiceImpl;
import service.impl.TeamLeadServiceImpl;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, NotFoundException, AlreadyExistException {

        ProjectServiceImpl projectService = new ProjectServiceImpl();
        //projectService.readAll();
        //projectService.readById(2);
        //projectService.readByEmail("test@gmail.com");
        //projectService.create(new Project("E-Magazine", 26984, "EM@gmail.com","123456em" ));
        //projectService.update(1486374984,new Project(1486374984,"Website", 984, "WS@gmail.com","123456ws" ));
        //projectService.delete(1486374984);

        TeamLeadServiceImpl teamLeadService = new TeamLeadServiceImpl();
        //teamLeadService.readAll();
    }
}
