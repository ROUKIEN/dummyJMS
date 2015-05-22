APPNAME=Q8
APPJAR=Q8.jar
CC=javac
INF=META-INF/

Q7: classes
	jar -cvf $(APPJAR) $(INF)*.xml *.class
classes:
	$(CC) *.java
clean:
	rm -rf *.class
