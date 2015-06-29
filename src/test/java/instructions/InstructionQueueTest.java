package instructions;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class InstructionQueueTest {

    // Fixtures
    InstructionMessage validMessage = new InstructionMessage(10, 1, 1, 1, 1);
    InstructionMessage validMessageMidPriority = new InstructionMessage(50, 1, 1, 1, 1);
    InstructionMessage validMessageLowPriority = new InstructionMessage(99, 1, 1, 1, 1);
    InstructionMessage invalidMessage = new InstructionMessage(-1,-1,-1,-1,-1);
    InstructionQueue queue;

    @Before
    public void init() {
        queue = new InstructionQueue(10);
    }

    @Test
    public void testThatQueueStartsEmpty() {
        assertThat(queue.getSize(), equalTo(0));
    }

    @Test
    public void testThatQueueRespondsCorrectlyWhenEmpty() {
        assert(queue.isEmpty());
    }

    @Test
    public void testThatMessagesCanBeAddedToAQueue() {
        assert(addMessageToQueue(queue, validMessage));
        assertThat(queue.getSize(), equalTo(1));
    }

    @Test(expected=InvalidMessageException.class)
    public void testThatInvalidMessagesCanNotBeAddedToAQueue() throws InvalidMessageException {
        try {
            queue.add(invalidMessage);
        } catch(InvalidMessageException ime) {
            throw ime;
        }
    }

    @Test
    public void testThatMultipleMessagesCanBeAddedToAQueue() {
        addMessageToQueue(queue, validMessage);
        addMessageToQueue(queue, validMessageMidPriority);
        assertThat(queue.getSize(), equalTo(2));
    }

    @Test
    public void testThatMessagesCanBeRemovedFromTheQueue() {
        addMessageToQueue(queue, validMessage);
        assertThat(queue.getSize(), equalTo(1));
        queue.remove(validMessage);
        assertThat(queue.getSize(), equalTo(0));
    }

    @Test
    public void testThatMessagesCanBeRetrievedFromTheQueue() {
        addMessageToQueue(queue, validMessage);
        InstructionMessage polledMessage = queue.poll();
        assertThat(validMessage.getInstructionType(), equalTo(polledMessage.getInstructionType()));
    }

    @Test
    public void testThatTheHighestPriorityMessageIsReturnedFromTheQueue() {
        addMessageToQueue(queue, validMessage);
        addMessageToQueue(queue, validMessageMidPriority);
        addMessageToQueue(queue, validMessageLowPriority);
        assertThat(queue.poll().getInstructionType(), equalTo(10));
    }

    @Test
    public void testThatMessagesAreReturnedInPriorityOrder() {
        addMessageToQueue(queue, validMessageLowPriority);
        addMessageToQueue(queue, validMessage);
        addMessageToQueue(queue, validMessageMidPriority);
        addMessageToQueue(queue, validMessage);
        assertThat(queue.poll().getInstructionType(), equalTo(10));
        assertThat(queue.poll().getInstructionType(), equalTo(10));
        assertThat(queue.poll().getInstructionType(), equalTo(50));
        assertThat(queue.poll().getInstructionType(), equalTo(99));
    }

    /*
     * Test Utils to save code duplication
     */
    private boolean addMessageToQueue(InstructionQueue queue, InstructionMessage message) {
        try {
            return queue.add(message);
        } catch(InvalidMessageException ime) {
            return false;
        }
    }
}
