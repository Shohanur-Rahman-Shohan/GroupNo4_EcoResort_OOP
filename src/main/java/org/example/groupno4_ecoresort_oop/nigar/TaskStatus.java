package org.example.groupno4_ecoresort_oop.nigar;

    public class TaskStatus {
        private String staffId;
        private String roomNumber;
        private String completedTask;
        private String incompleteTask;
        private String timeSchedule;
        private String feedback;

        public TaskStatus(String staffId, String roomNumber, String completedTask,
                          String incompleteTask, String timeSchedule, String feedback) {
            this.staffId = staffId;
            this.roomNumber = roomNumber;
            this.completedTask = completedTask;
            this.incompleteTask = incompleteTask;
            this.timeSchedule = timeSchedule;
            this.feedback = feedback;
        }

        public String getStaffId() { return staffId; }
        public String getRoomNumber() { return roomNumber; }
        public String getCompletedTask() { return completedTask; }
        public String getIncompleteTask() { return incompleteTask; }
        public String getTimeSchedule() { return timeSchedule; }
        public String getFeedback() { return feedback; }
    }



