import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


class Vertex {

    public String label;

    public boolean isVisited;


    public Vertex(String label) {

        this.label = label;
    }
}

class Grapi {

    int numOfVertices = 100;


    Vertex[] vertices;


    int[][] adjMatrix;


    int indicesCount = 0;


    public Grapi(int numOfVertices) {

        this.numOfVertices = numOfVertices;

        adjMatrix = new int[this.numOfVertices][this.numOfVertices];

        this.vertices = new Vertex[this.numOfVertices];

        initAdjMatrix();

    }


    void initAdjMatrix() {

        for (int i = 0; i < this.numOfVertices; i++) {
            for (int j = 0; j < this.numOfVertices; j++) {
                this.adjMatrix[i][j] = 0;
            }
        }
    }
}

public class GrapiTest {

    @Test
    public void bidi_Test() {


        assertThat(true).isEqualTo(true);
    }
}
