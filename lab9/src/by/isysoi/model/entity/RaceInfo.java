package by.isysoi.model.entity;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(
                name = "updateHorsePosition",
                query = "update RaceInfo set position = :position where raceId = :raceId and horseId = :horseId"
        )
})
@Entity(name = "RaceInfo")
@Table(name = RaceInfo.tableName)
public class RaceInfo {

    public static final String tableName = "race_info";
    private static final String raceColumnName = "race_id";
    private static final String horseColumnName = "horse_id";

    /**
     * id of race
     */
    @Id
    @Column(name = RaceInfo.raceColumnName)
    private int raceId;

    @Id
    @Column(name = RaceInfo.horseColumnName)
    private int horseId;

    @Column(nullable = true)
    private int position;


    @Override
    public String toString() {
        return "";//String.format("Race:\n\tid - %d\n\tdistance - %.2f\n\tdate - %s", id, distance, raceDate.toString());
    }
}
