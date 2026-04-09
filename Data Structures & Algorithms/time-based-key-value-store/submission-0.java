class TimeMap {
    Map<String, List<Entry>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        Entry entry = new Entry();
        entry.value = value;
        entry.timestamp = timestamp;
        map.get(key).add(entry);
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";

        List<Entry> entries = map.get(key);

        int left = 0;
        int right = entries.size() - 1;

        String value = "";

        while(left <= right) {
            int mid = left + (right - left)/ 2;
            Entry midEntry = entries.get(mid);

            if(midEntry.timestamp <= timestamp) {
                value = midEntry.value;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return value;
    }
}

class Entry{
    public int timestamp;
    public String value;
}