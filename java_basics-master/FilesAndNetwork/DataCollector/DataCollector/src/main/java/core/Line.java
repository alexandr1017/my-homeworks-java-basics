package core;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@NoArgsConstructor
@ToString
@Getter
public class Line {

    private String line;
    private String name;

    public Line(String lineNumber, String nameLine) {
        this.line = lineNumber;
        this.name = nameLine;
    }


}
