import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Solution {
    public int solution(String[] rawFriends, String[] gifts) {
        Friends friends = new Friends(rawFriends);
        friends.sendGifts(gifts);
        return friends.calculateMaxNextMonth();
    }

    private static class Friends {
        private final Map<String, Friend> friends = new HashMap<>();

        public Friends(String[] friends) {
            for (String friend : friends) {
                addFriend(friend);
            }
        }

        public void sendGifts(String[] gifts) {
            for (String gift : gifts) {
                String[] senderReceiver = gift.split(" ");
                sendGift(senderReceiver[0], senderReceiver[1]);
            }
        }

        public void sendGift(String sender, String receiver) {
            Friend senderFriend = friends.get(sender);
            Friend receiverFriend = friends.get(receiver);

            senderFriend.sendGift(receiverFriend);
            receiverFriend.receiveGift(senderFriend);
        }

        public int calculateMaxNextMonth() {
            Map<Friend, Integer> receivedGifts = new HashMap<>();

            for (Friend friend : friends.values()) {
                for (Friend otherFriend : friends.values()) {
                    if (friend.isSame(otherFriend)) {
                        continue;
                    }

                    if (friend.shouldReceiveFrom(otherFriend)) {
                        receivedGifts.put(friend, receivedGifts.getOrDefault(friend, 0) + 1);
                    }
                }
            }

            return receivedGifts.values().stream()
                    .max(Integer::compareTo)
                    .orElse(0);
        }

        public void addFriend(String name) {
            friends.put(name, new Friend(name));
        }
    }

    private static class Friend {
        private final String name;
        private final Map<Friend, Integer> receivedGifts = new HashMap<>();
        private final Map<Friend, Integer> sentGifts = new HashMap<>();
        private int giftIndex = 0;

        public Friend(String name) {
            this.name = name;
        }

        public void sendGift(Friend friend) {
            this.sentGifts.put(friend, sentGifts.getOrDefault(friend, 0) + 1);
            this.giftIndex++;
        }

        public void receiveGift(Friend friend) {
            this.receivedGifts.put(friend, receivedGifts.getOrDefault(friend, 0) + 1);
            this.giftIndex--;
        }

        public boolean isSame(Friend friend) {
            return this.name.equals(friend.name);
        }

        public boolean shouldReceiveFrom(Friend friend) {
            int received = receivedGifts.getOrDefault(friend, 0);
            int sent = sentGifts.getOrDefault(friend, 0);

            if (received == sent) {
                return this.giftIndex > friend.giftIndex;
            }

            return received < sent;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Friend friend = (Friend) o;
            return Objects.equals(name, friend.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }
}