/*
DESCRIPTION:
Remember the times when every website had a counter? A friend of yours runs one of those sites.

But as his site gains popularity, he observes some strange behavior: Sometimes, when there are many users accessing his page, the counter does not represent what he can get from the access logs.

Knowing your programming skills, he asks you to investigate. You look at his code and immediately see what's wrong: his VisitorStatistics implementation is not thread-safe.

"No big deal," you tell him. "I'll fix it in no time!"
*/

import java.util.HashMap;
import java.util.Map;

public class VisitorStatistics {
    private long counter;
    private Map<String, Long> visitorCount = new HashMap<>();

    public synchronized void visit(String name) {
        counter++;
        Long oldCount = visitorCount.get(name);
        long newCount = 1L;
        if (oldCount != null) {
            newCount += oldCount;
        }
        visitorCount.put(name, newCount);
    }

    public long totalVisits() {
        return counter;
    }

    public long visitsBy(String name) {
        return visitorCount.getOrDefault(name, 0L);
    }
}