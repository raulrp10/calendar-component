package org.vaadin.addon.calendar.demo.meetings;

import com.vaadin.icons.VaadinIcons;
import org.vaadin.addon.calendar.item.BasicItem;

import java.time.ZonedDateTime;

/**
 * Meeting Pojo
 */

public class MeetingItem extends BasicItem {

	private final Meeting meeting;

	/**
	 * constructor
	 *
	 * @param meeting A meeting
	 */

	public MeetingItem(Meeting meeting) {
        super(meeting.getDetails(), null, meeting.getStart().plusMinutes(30), meeting.getEnd().plusMinutes(30));
        this.meeting = meeting;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof MeetingItem)) {
			return false;
		}
		MeetingItem that = (MeetingItem) o;
		return getMeeting().equals(that.getMeeting());
	}

	public Meeting getMeeting() {
		return meeting;
	}

	@Override
	public String getStyleName() {
		return "state-" + meeting.getState().name().toLowerCase();
	}

	@Override
	public int hashCode() {
		return getMeeting().hashCode();
	}

	@Override
	public boolean isAllDay() {
		return meeting.isLongTimeEvent();
	}

    @Override
    public boolean isMoveable() {
        return meeting.isEditable();
    }

    @Override
    public boolean isResizeable() {
        return meeting.isEditable();
    }

//    @Override
//    public boolean isClickable() {
//        return meeting.isEditable();
//    }

    @Override
	public void setEnd(ZonedDateTime end) {
		meeting.setEnd(end);
		super.setEnd(end);
	}

	@Override
	public void setStart(ZonedDateTime start) {
		meeting.setStart(start);
		super.setStart(start);
	}

    @Override
    public String getDateCaptionFormat() {
        //return CalendarItem.RANGE_TIME;
        return VaadinIcons.CLOCK.getHtml()+" %s<br>" +
               VaadinIcons.ARROW_CIRCLE_RIGHT_O.getHtml()+" %s";
	}

}