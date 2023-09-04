package core;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Getter
@Setter
public class RootMetro {
    private Map<String, List<String>> stations;
    private List<Line> lines;

    public RootMetro(Map<String, List<String>> mapLines, List<Line> lines) {
        stations = mapLines;
        this.lines = lines;
    }

}

