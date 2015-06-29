package instructions;

import java.util.Comparator;
import java.util.PriorityQueue;

public class InstructionQueue {

    // Composition over inheritance
    private PriorityQueue<InstructionMessage> queue;

    public InstructionQueue(int maxSize) {
        queue = new PriorityQueue<InstructionMessage>(maxSize, new MessageComparator<InstructionMessage>());
    }

    public boolean isEmpty() {
        return queue.size() == 0;
    }

    public InstructionMessage poll() {
        return queue.poll();
    }

    /*
     * Validate the message before adding it to the queue
     */
    public boolean add(InstructionMessage message) throws InvalidMessageException {

        if(message.getInstructionType() <= 0 || message.getInstructionType() >= 100) {
            throw new InvalidMessageException("instructionType must be > 0 and < 100");
        }
        if(message.getProductCode() <= 0) {
            throw new InvalidMessageException("productCode must be <= 0");
        }
        if(message.getQuantity() <= 0) {
            throw new InvalidMessageException("quantity must be <= 0");
        }
        if(message.getUOM() < 0 || message.getUOM() >= 256) {
            throw new InvalidMessageException("uom must be > 0 and <= 256");
        }
        if(message.getTimeStamp() <= 0) {
            throw new InvalidMessageException("timeStamp must be > 0");
        }

        return queue.add(message);
    }

    public boolean remove(InstructionMessage message) {
        return queue.remove(message);
    }

    public int getSize() {
        return queue.size();
    }

    // Could do this inline above if preferred
    static class MessageComparator<E> implements Comparator<InstructionMessage> {
            public int compare(InstructionMessage message1, InstructionMessage message2) {
                int a1 = message1.getInstructionType();
                int a2 = message2.getInstructionType();

                  if(a1 > a2) {
                      return 1;
                  }
                  return -1;
            }
       }

}
