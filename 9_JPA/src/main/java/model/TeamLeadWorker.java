package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "team_lead_worker")
public class TeamLeadWorker implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "team_lead_id", referencedColumnName = "id")
    private TeamLead teamLead;
    @Id
    @ManyToOne
    @JoinColumn(name = "worker_id", referencedColumnName = "id")
    private Worker worker;
    @Column(name = "worker_count")
    private int workerCount;
}
