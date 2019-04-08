package api.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Badge {
    private String badge_type;
    private Long award_count;
    private String rank;
    private Long badge_id;
    private String link;
    private String name;
}
