
public class TrafficLight {
	 private String currentState;
	    private static final String[] STATES = { "red", "green", "amber" };
	    private static final String[] STATE_TRANSITIONS = { "green", "amber", "red" };


	    public TrafficLight() {
	        currentState = STATES[0];
	    }


	    private boolean isValidState(String state) {
	        boolean result = false;


	        if (state != null) {
	            for (String validState : STATES) {
	                if (validState.equals(state)) {
	                    result = true;
	                    break;
	                }
	            }
	        }


	        return result;
	    }
	    public TrafficLight(String firstState) {
	        if (!isValidState(firstState)) { System.err.println("firstState must be valid!"); currentState = STATES[0];
	        }
	        else {
	        	currentState = firstState;
	        	}
	        }

	    /**
	     * Changes to the next traffic light state and returns the next state.
	     *
	     * @return the next state of this traffic light.
	     */
	    
	    public String changeLight() { int foundIndex = 0; boolean done = false;


	        for (int i = 0; i < STATES.length && !done; i++) {
	            if (currentState.equals(STATES[i])) {
	                foundIndex = i;
	                done = true; // can leave it out
	            }
	        }


	        currentState = STATE_TRANSITIONS[foundIndex];
	        return currentState;
	    }


	    @Override
	    public String toString() {
	        return currentState;
	    }


	    public static void main(String[] args) { TrafficLight t1 = new TrafficLight(); System.out.println(t1);
	        for (int i = 0; i < 4; i++) {
	            System.out.println(t1.changeLight());
	        }
	    }
	}

