package queuecode2;

class Edge {
    SignUp source;
    SignUp destination;

    boolean bidirectional;

    public Edge(SignUp source, SignUp destination,Boolean bidirectional) {
        this.source = source;
        this.destination = destination;
        
       // this.weight = weight;
        this.bidirectional=bidirectional;
        
    }
 }