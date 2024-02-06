package board.v1;

import lombok.Data;

import java.util.Date;

@Data
public class Board {
    private int bno;
    private String btitle;
    private String bcontent;
    private Date date;
}
