package ohtuesimerkki;

import java.util.List;
import java.util.ArrayList;
import org.junit.Test; // for @Test
import org.junit.Before; // for @Before
import static org.junit.Assert.*;


public class StatisticsTest {
 
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }  

    @Test 
    public void ekaTesti(){
        Player p = stats.search("Kurri");
        assertEquals ("Kurri", p.getName());
    }

    @Test
    public void tokaTesti(){
        List<Player> p = stats.topScorers(1);
        System.out.println(p.get(0).getName());

    }

    @Test
    public void kolmasTesti(){
        List<Player> p = stats.team("DET");
        assertEquals(1, p.size());
    }

    @Test
    public void searchNotFoundReturnsNull(){
        Player p = stats.search("foo");
        assertEquals(null, p);
    }

    @Test
    public void constructorTest(){
        Statistics s = new Statistics();
        s.toString();
    }
}