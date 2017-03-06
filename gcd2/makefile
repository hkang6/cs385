NAME = Problem
SRC = gcd.cpp
OBJ = $(SRC:.cpp=.o)
RM = rm -fv

all: $(OBJ)
	g++ $(OBJ) -o $(NAME)
clean:
	$(RM) *.o
	$(RM) \#*
	$(RM) *~
	$(RM) *core
	$(RM) *stackdump

fclean: clean
	$(RM) $(NAME)

re: clean all
