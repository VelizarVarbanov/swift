import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Paulina on 10.11.2016 г..
 */
public class Task1_FilterFilesTest {
    @Test
    public void matchingFirst() {
        assertFalse(Task1_FilterFiles.matching(".bash_profile"));
    }
    @Test
    public void matchingSec() {
        assertTrue(Task1_FilterFiles.matching("updated_img0912.png"));
    }
}