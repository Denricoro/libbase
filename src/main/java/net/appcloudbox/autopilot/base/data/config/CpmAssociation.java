package net.appcloudbox.autopilot.base.data.config;

import java.util.List;
import java.util.Map;

public final class CpmAssociation {
    public final Map<String, CpmEvent> cpmEventsMap;

    public CpmAssociation(Map<String, CpmEvent> cpmEventsMap) {
        this.cpmEventsMap = cpmEventsMap;
    }

    public final static class CpmEvent {
        public final String eventName;
        public final List<String> triggers;

        public CpmEvent(String eventName, List<String> triggers) {
            this.eventName = eventName;
            this.triggers = triggers;
        }
    }
}
