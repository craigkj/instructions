package instructions;

public class Main {
    public static void main(String[] args) {
        // Placeholder
        InstructionQueue queue = new InstructionQueue(10);
        InstructionMessage validMessage = new InstructionMessage(10, 1, 1, 1, 1);
        InstructionMessage validMessageMidPriority = new InstructionMessage(50, 1, 1, 1, 1);
        InstructionMessage validMessageLowPriority = new InstructionMessage(99, 1, 1, 1, 1);
        
        addMessageToQueue(queue, validMessageLowPriority);
        addMessageToQueue(queue, validMessage);
        addMessageToQueue(queue, validMessageMidPriority);
        addMessageToQueue(queue, validMessage);
        System.out.println(queue.poll().getInstructionType());
        System.out.println(queue.poll().getInstructionType());
        System.out.println(queue.poll().getInstructionType());
        System.out.println(queue.poll().getInstructionType());
    }

    private static boolean addMessageToQueue(InstructionQueue queue, InstructionMessage message) {
        try {
            return queue.add(message);
        } catch(InvalidMessageException ime) {
            return false;
        }
    }
}
