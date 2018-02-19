clean: sigue
	rm *.o *~ lan

sigue:
	clear

grafo: Point1.o Edge.o Vertex.o DinaGraph.o
	g++ -g -o $@ $^

Point1.o: Point1.cpp

Edge.o: Edge.cpp

Vertex.o: Vertex.cpp

DinaGraph.o: DinaGraph.cpp
