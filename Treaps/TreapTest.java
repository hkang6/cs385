//Harkirat Kang
//I Pledge my honor that I have abided by the Stevens Honor System

import static org.junit.Assert.*;

import org.junit.Test;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.assertEquals;

public class TreapTest {
    @Test
    public void testAdd() {
        Treap<Integer> testTreap = new Treap<>();
        boolean add1 = testTreap.add( 9, 15 );
        boolean add2 = testTreap.add( 25, 5 );
        boolean add3 = testTreap.add( 7, 2 );
        boolean add4 = testTreap.add( 25 );
        boolean add5 = testTreap.add( 3 );

        assertEquals( add1, true );
        assertEquals( add2, true );
        assertEquals( add3, true );
        assertEquals( add4, false );
        assertEquals( add5, true );
    }

    @Test
    public void testDelete() {
        Treap<Integer> testTreap = new Treap<>();
        testTreap.add( 9, 15 );
        testTreap.add( 25, 5 );
        testTreap.add( 7, 2 );

        boolean del1 = testTreap.delete( 7 );
        boolean del2 = testTreap.delete( 20 );

        assertEquals( del1, true );
        assertEquals( del2, false );

        boolean del3 = testTreap.delete( 7 );
        boolean del4 = testTreap.delete( 25 );

        assertEquals( del3, false );
        assertEquals( del4, true );
    }

    @Test
    public void testFind() {
        Treap<Integer> testTreap = new Treap<>();
        testTreap.add( 1, 6 );
        testTreap.add( 2, 5 );
        testTreap.add( 3, 4 );

        assertEquals( testTreap.find( 1 ), (Integer) 1);
        assertEquals( testTreap.find( 3 ), (Integer) 3 );
        assertEquals( testTreap.find( 8 ), null );
    }

    @Test
    public void testToString() {
        Treap<Integer> testTreap = new Treap<>();

        assertEquals( testTreap.toString(), "null\n" );

        testTreap.add( 5, 30 );
        assertEquals( testTreap.toString(), "(key=5, priority=30)\n  null\n  null\n" );

        testTreap.add( 8, 12 );
        assertEquals( testTreap.toString(), "(key=5, priority=30)\n  null\n  (key=8, priority=12)\n    null\n    null\n" );
    }


    public static void main( String[] args ) {
        Result result = JUnitCore.runClasses(TreapTest.class);

        for( Failure failure : result.getFailures() )
            System.out.println( failure.toString() );

        System.out.println( result.wasSuccessful() );
    }
}

