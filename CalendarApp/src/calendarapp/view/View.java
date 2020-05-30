package calendarapp.View;

import calendarapp.Controller.Controller;
import calendarapp.view.YearCenterPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SpringLayout;

public class View {

    private final Controller controller;

    private final InitialFrame initialFrame;
    private final String dateToday;
    private final ArrayList<String> eventArrayList;
    private final ArrayList<JButton> eventButtonArray;
    private final ArrayList<JLabel> weatherLabelArray;
    private final HashMap<Integer, ArrayList<Integer>> dateHashMap;
    private final HashMap<Integer, ArrayList<String>> dayHashMap;
    private Dimension screenSize;
    private NewEvent newEvent;

    public View(String dateToday, ArrayList<String> eventArrayList, HashMap<Integer, ArrayList<Integer>> dateHashMapIn, HashMap<Integer, ArrayList<String>> dayHashMapIn, Controller controller) throws IOException {
        this.controller = controller;
        this.dateToday = dateToday;
        this.eventArrayList = eventArrayList;
        this.dateHashMap = dateHashMapIn;
        this.dayHashMap = dayHashMapIn;
        eventButtonArray = new ArrayList<>();
        weatherLabelArray = new ArrayList<>();
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        initialFrame = new InitialFrame(eventArrayList, screenSize);
        initialFrame.setSize(screenSize.width, screenSize.height);
        initialFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        initialFrame.setVisible(true);
        initialFrame.setExtendedState(initialFrame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        String[] dateTodayArray = dateToday.split(", ");

        initialFrame.getInitialPanel().getRightPanel().getNorthPanel().getUpMonth().addActionListener((ActionEvent e) -> {
            removeWeather();
            clearEvent();
            int counterMonth = 0;
            int currentMonth = getCurrentMonth();

            if (currentMonth >= 1) {
                int numberOfDayToFill = 5 - (7 - dateHashMap.get(currentMonth - 2).get(0));
                if (dateHashMap.get(currentMonth - 2).get(0) != 1 && currentMonth != 12) {
                    int maxNumberPreviousMonth = dateHashMap.get(currentMonth).get(1) - numberOfDayToFill;
                    for (int k = 0; k <= numberOfDayToFill; k++) {
                        initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(k).getNumber().setText(Integer.toString(maxNumberPreviousMonth));
                        initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(k).getNumber().setFont(new Font("Times New Roman", Font.BOLD, screenSize.width / 125));
                        initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(k).getNumber().setForeground(Color.gray);
                        maxNumberPreviousMonth++;
                    }
                } else if (currentMonth - 1 == 1) {
                    for (int k = 0; k <= numberOfDayToFill; k++) {
                        initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(k).getNumber().setText("");
                        initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(k).getNumber().setFont(new Font("Times New Roman", Font.BOLD, screenSize.width / 125));
                        initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(k).getNumber().setForeground(Color.gray);
                    }
                }

                if (initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().size() >= dateHashMap.get(currentMonth - 2).get(0) - 1 + dateHashMap.get(currentMonth - 2).get(1)) {

                    for (int i = 1; i <= dateHashMap.get(currentMonth - 2).get(1); i++) {
                        initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(dateHashMap.get(currentMonth - 2).get(0) - 1 + counterMonth).getNumber().setText(Integer.toString(i));
                        initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(dateHashMap.get(currentMonth - 2).get(0) - 1 + counterMonth).getNumber().setFont(new Font("Times New Roman", Font.BOLD, screenSize.width / 125));
                        for (int j = dateHashMap.get(currentMonth - 2).get(0) - 1; j <= (dateHashMap.get(currentMonth - 2).get(1) + dateHashMap.get(currentMonth - 2).get(0) - 1) - 1; j++) {
                            initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(j).getNumber().setForeground(Color.black);
                            initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(j).setBorder(BorderFactory.createLineBorder(Color.black, 1));
                        }

                        counterMonth++;
                    }
                    setCurrentMonth(currentMonth - 1);
                    addEvents(currentMonth - 1);
                    setUpWeather(dateTodayArray[0], dateTodayArray[1]);

                    int counterMonthV2 = 1;
                    for (int k = dateHashMap.get(currentMonth - 2).get(1) + (dateHashMap.get(currentMonth - 2).get(0) - 1); k < initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().size(); k++) {
                        initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(k).getNumber().setText(Integer.toString(counterMonthV2) + " ");
                        initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(k).getNumber().setFont(new Font("Times New Roman", Font.BOLD, screenSize.width / 125));
                        initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(k).getNumber().setForeground(Color.gray);
                        counterMonthV2++;
                    }
                } else if (initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().size() < dateHashMap.get(currentMonth - 2).get(0) - 1 + dateHashMap.get(currentMonth - 2).get(1)) {
                    int numberOfExta = (dateHashMap.get(currentMonth - 2).get(0) - 1 + dateHashMap.get(currentMonth - 2).get(1)) - initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().size();
                    for (int i = 1; i <= dateHashMap.get(currentMonth - 2).get(1) - numberOfExta; i++) {
                        initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(dateHashMap.get(currentMonth - 2).get(0) - 1 + counterMonth).getNumber().setText(Integer.toString(i));
                        initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(dateHashMap.get(currentMonth - 2).get(0) - 1 + counterMonth).getNumber().setFont(new Font("Times New Roman", Font.BOLD, screenSize.width / 125));
                        for (int j = dateHashMap.get(currentMonth - 2).get(0) - 1; j < initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().size(); j++) {
                            initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(j).getNumber().setForeground(Color.black);
                            initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(j).setBorder(BorderFactory.createLineBorder(Color.black, 1));
                        }
                        counterMonth++;
                    }
                    setCurrentMonth(currentMonth - 1);
                    addEvents(currentMonth - 1);
                    setUpWeather(dateTodayArray[0], dateTodayArray[1]);
                }
            } else {
                JOptionPane.showMessageDialog(initialFrame, "Option not supported yet!");
                addEvents(currentMonth);
                setUpWeather(dateTodayArray[0], dateTodayArray[1]);
            }
            for (int i = 0; i < initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().size(); i++) {
                if (initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(i).getNumber().getText().equals(dateTodayArray[1]) && currentMonth == Integer.parseInt(dateTodayArray[0]) + 1) {
                    initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(i).setBorder(BorderFactory.createLineBorder(Color.decode("#FF9D00"), 3));
                }
            }
        });

        initialFrame.getInitialPanel().getRightPanel().getNorthPanel().getDownMonth().addActionListener((ActionEvent e) -> {
            removeWeather();
            clearEvent();
            int counterMonth = 0;
            int currentMonth = getCurrentMonth();
            for (int i = 0; i < initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().size(); i++) {
                initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(i).setBorder(BorderFactory.createLineBorder(Color.black, 1));
            }
            if (currentMonth != 12) {
                if (initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().size() >= dateHashMap.get(currentMonth).get(0) - 1 + dateHashMap.get(currentMonth).get(1)) {
                    if (currentMonth == 0) {
                        if (dateHashMap.get(currentMonth + 1).get(0) - 1 != 1 && currentMonth + 1 != 12) {
                            int numberOfDayToFill = 5 - (7 - dateHashMap.get(currentMonth + 1).get(0));
                            int maxNumberPreviousMonth = dateHashMap.get(currentMonth).get(1) - numberOfDayToFill;
                            for (int k = 0; k <= numberOfDayToFill; k++) {
                                initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(k).getNumber().setText(Integer.toString(maxNumberPreviousMonth));
                                initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(k).getNumber().setFont(new Font("Times New Roman", Font.BOLD, screenSize.width / 125));
                                initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(k).getNumber().setForeground(Color.gray);
                                maxNumberPreviousMonth++;
                            }
                        }
                        for (int i = 1; i <= dateHashMap.get(currentMonth + 1).get(1); i++) {
                            initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(dateHashMap.get(currentMonth + 1).get(0) - 1 + counterMonth).getNumber().setText(Integer.toString(i));
                            initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(dateHashMap.get(currentMonth + 1).get(0) - 1 + counterMonth).getNumber().setFont(new Font("Times New Roman", Font.BOLD, screenSize.width / 125));
                            for (int j = dateHashMap.get(currentMonth + 1).get(0) - 1; j <= dateHashMap.get(currentMonth + 1).get(1) + (dateHashMap.get(currentMonth + 1).get(0) - 1) - 1; j++) {
                                initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(j).getNumber().setForeground(Color.black);
                                initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(j).setBorder(BorderFactory.createLineBorder(Color.black, 1));
                            }
                            counterMonth++;
                        }
                        setCurrentMonth(currentMonth + 2);
                    } else if (currentMonth >= 1) {
                        if (dateHashMap.get(currentMonth).get(0) - 1 != 0 && currentMonth != 12) {
                            int numberOfDayToFill = 5 - (7 - dateHashMap.get(currentMonth).get(0) - 1);
                            int maxNumberPreviousMonth = dateHashMap.get(currentMonth - 1).get(1) - numberOfDayToFill + 1;
                            for (int k = 0; k <= numberOfDayToFill; k++) {
                                initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(k).getNumber().setText(Integer.toString(maxNumberPreviousMonth));
                                initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(k).getNumber().setFont(new Font("Times New Roman", Font.BOLD, screenSize.width / 125));
                                initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(k).getNumber().setForeground(Color.gray);
                                maxNumberPreviousMonth++;
                            }
                        }
                        for (int i = 1; i <= dateHashMap.get(currentMonth).get(1); i++) {
                            initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(dateHashMap.get(currentMonth).get(0) - 1 + counterMonth).getNumber().setText(Integer.toString(i));
                            initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(dateHashMap.get(currentMonth).get(0) - 1 + counterMonth).getNumber().setFont(new Font("Times New Roman", Font.BOLD, screenSize.width / 125));
                            for (int j = dateHashMap.get(currentMonth).get(0) - 1; j <= dateHashMap.get(currentMonth).get(1) + (dateHashMap.get(currentMonth).get(0) - 1) - 1; j++) {
                                initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(j).getNumber().setForeground(Color.black);
                                initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(j).setBorder(BorderFactory.createLineBorder(Color.black, 1));
                            }
                            counterMonth++;
                        }
                        setCurrentMonth(currentMonth + 1);
                        addEvents(currentMonth + 1);
                        setUpWeather(dateTodayArray[0], dateTodayArray[1]);
                    }

                    int counterMonthV2 = 1;
                    for (int k = dateHashMap.get(currentMonth).get(1) + dateHashMap.get(currentMonth).get(0) - 1; k < initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().size(); k++) {
                        initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(k).getNumber().setText(Integer.toString(counterMonthV2) + " ");
                        initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(k).getNumber().setFont(new Font("Times New Roman", Font.BOLD, screenSize.width / 125));
                        initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(k).getNumber().setForeground(Color.gray);
                        counterMonthV2++;
                    }
                } else if (initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().size() < dateHashMap.get(currentMonth).get(0) - 1 + dateHashMap.get(currentMonth).get(1)) {
                    if (dateHashMap.get(currentMonth).get(0) - 1 != 0 && currentMonth != 12) {
                        int numberOfDayToFill = 5 - (7 - dateHashMap.get(currentMonth).get(0) - 1);
                        int maxNumberPreviousMonth = dateHashMap.get(currentMonth - 1).get(1) - numberOfDayToFill + 1;
                        for (int k = 0; k < numberOfDayToFill; k++) {
                            initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(k).getNumber().setText(Integer.toString(maxNumberPreviousMonth));
                            initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(k).getNumber().setFont(new Font("Times New Roman", Font.BOLD, screenSize.width / 125));
                            initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(k).getNumber().setForeground(Color.gray);
                            maxNumberPreviousMonth++;
                        }
                    }
                    int numberOfExta = (dateHashMap.get(currentMonth).get(0) - 1 + dateHashMap.get(currentMonth).get(1)) - initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().size();
                    for (int i = 1; i <= dateHashMap.get(currentMonth).get(1) - numberOfExta; i++) {
                        initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(dateHashMap.get(currentMonth).get(0) - 1 + counterMonth).getNumber().setText(Integer.toString(i));
                        initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(dateHashMap.get(currentMonth).get(0) - 1 + counterMonth).getNumber().setFont(new Font("Times New Roman", Font.BOLD, screenSize.width / 125));
                        for (int j = dateHashMap.get(currentMonth).get(0) + 1; j < initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().size(); j++) {
                            initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(j).getNumber().setForeground(Color.black);
                            initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(j).setBorder(BorderFactory.createLineBorder(Color.black, 1));
                        }
                        setCurrentMonth(currentMonth + 1);
                        addEvents(currentMonth + 1);
                        setUpWeather(dateTodayArray[0], dateTodayArray[1]);
                        counterMonth++;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(initialFrame, "Option not supported yet!");
                addEvents(currentMonth);
                setUpWeather(dateTodayArray[0], dateTodayArray[1]);
            }
            for (int i = 0; i < initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().size(); i++) {
                if (initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(i).getNumber().getText().equals(dateTodayArray[1]) && currentMonth == Integer.parseInt(dateTodayArray[0]) - 1) {
                    initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(i).setBorder(BorderFactory.createLineBorder(Color.decode("#FF9D00"), 3));
                }
            }
        });

        initialFrame.getInitialPanel().getRightPanel().getNorthPanel().getTodayButton().addActionListener((ActionEvent e) -> {
            setUpTodayView();
        });

        initialFrame.getInitialPanel().getLeftPanel().getNewEvent().addActionListener((ActionEvent e) -> {
            try {
                newEvent = new NewEvent(screenSize);
            } catch (ParseException ex) {
                System.out.println(ex.getMessage());
            }

            newEvent.setSize(screenSize.height / 2, screenSize.width / 2);
            newEvent.setLocationRelativeTo(null);
            newEvent.getNewEventInitialPanel().remove(newEvent.getNewEventInitialPanel().getDelete());
            newEvent.setVisible(true);

            newEvent.getNewEventInitialPanel().getAmStart().addActionListener((ActionEvent e1) -> {
                newEvent.getNewEventInitialPanel().getAllDay().setSelected(false);
                newEvent.getNewEventInitialPanel().getPmStart().setSelected(false);
                newEvent.getNewEventInitialPanel().getStartTime().setFocusable(true);
                newEvent.getNewEventInitialPanel().getEndTime().setFocusable(true);
            });

            newEvent.getNewEventInitialPanel().getPmStart().addActionListener((ActionEvent e1) -> {
                newEvent.getNewEventInitialPanel().getAllDay().setSelected(false);
                newEvent.getNewEventInitialPanel().getAmStart().setSelected(false);
                newEvent.getNewEventInitialPanel().getStartTime().setFocusable(true);
                newEvent.getNewEventInitialPanel().getEndTime().setFocusable(true);
            });

            newEvent.getNewEventInitialPanel().getAmEnd().addActionListener((ActionEvent e1) -> {
                newEvent.getNewEventInitialPanel().getAllDay().setSelected(false);
                newEvent.getNewEventInitialPanel().getPmEnd().setSelected(false);
                newEvent.getNewEventInitialPanel().getStartTime().setFocusable(true);
                newEvent.getNewEventInitialPanel().getEndTime().setFocusable(true);
            });

            newEvent.getNewEventInitialPanel().getPmEnd().addActionListener((ActionEvent e1) -> {
                newEvent.getNewEventInitialPanel().getAllDay().setSelected(false);
                newEvent.getNewEventInitialPanel().getAmEnd().setSelected(false);
                newEvent.getNewEventInitialPanel().getStartTime().setFocusable(true);
                newEvent.getNewEventInitialPanel().getEndTime().setFocusable(true);
            });

            newEvent.getNewEventInitialPanel().getAllDay().addActionListener((ActionEvent e1) -> {
                if (!newEvent.getNewEventInitialPanel().getAllDay().isSelected()) {
                    newEvent.getNewEventInitialPanel().getAllDay().setSelected(false);
                    newEvent.getNewEventInitialPanel().getStartTime().setFocusable(true);
                    newEvent.getNewEventInitialPanel().getEndTime().setFocusable(true);
                } else {
                    newEvent.getNewEventInitialPanel().getStartTime().setText("12:00:00");
                    newEvent.getNewEventInitialPanel().getAmStart().setSelected(true);
                    newEvent.getNewEventInitialPanel().getPmStart().setSelected(false);
                    newEvent.getNewEventInitialPanel().getEndTime().setText("11:59:59");
                    newEvent.getNewEventInitialPanel().getAmEnd().setSelected(false);
                    newEvent.getNewEventInitialPanel().getPmEnd().setSelected(true);
                    newEvent.getNewEventInitialPanel().getStartTime().setFocusable(false);
                    newEvent.getNewEventInitialPanel().getEndTime().setFocusable(false);
                }
            });

            newEvent.getNewEventInitialPanel().getSave().addActionListener((ActionEvent e2) -> {
                String[] startDate = newEvent.getNewEventInitialPanel().getStartDate().getText().split("/");
                String[] startTime = newEvent.getNewEventInitialPanel().getStartTime().getText().split(":");
                String[] endDate = newEvent.getNewEventInitialPanel().getEndDate().getText().split("/");
                String[] endTime = newEvent.getNewEventInitialPanel().getEndTime().getText().split(":");
                int startTimeHour;
                int endTimeHour;
                if (newEvent.getNewEventInitialPanel().getEventName().getText().equals("Event Name")
                        || newEvent.getNewEventInitialPanel().getStartDate().getText().equals("__/__/____")
                        || newEvent.getNewEventInitialPanel().getEndDate().getText().equals("__/__/____")
                        || newEvent.getNewEventInitialPanel().getStartTime().getText().equals("__:__:__")
                        || newEvent.getNewEventInitialPanel().getEndTime().getText().equals("__:__:__")
                        || Integer.parseInt(startDate[0]) > 12 || Integer.parseInt(startDate[0]) < 1
                        || Integer.parseInt(startDate[1]) > 31 || Integer.parseInt(startDate[1]) < 1
                        || Integer.parseInt(startTime[0]) > 12
                        || Integer.parseInt(startTime[1]) > 59
                        || Integer.parseInt(startTime[2]) > 59
                        || Integer.parseInt(endDate[0]) > 12 || Integer.parseInt(endDate[0]) < 1
                        || Integer.parseInt(endDate[1]) > 31 || Integer.parseInt(endDate[1]) < 1
                        || Integer.parseInt(endTime[0]) > 12
                        || Integer.parseInt(endTime[1]) > 59
                        || Integer.parseInt(endTime[2]) > 59 || (!newEvent.getNewEventInitialPanel().getAmStart().isSelected() && !newEvent.getNewEventInitialPanel().getPmStart().isSelected())
                        || (!newEvent.getNewEventInitialPanel().getAmEnd().isSelected() && !newEvent.getNewEventInitialPanel().getPmEnd().isSelected())) {
                    JOptionPane.showMessageDialog(newEvent, "You must enter a valid event name, start date, end date, start time, and end time!");
                } else {

                    if (newEvent.getNewEventInitialPanel().getPmStart().isSelected()) {
                        startTimeHour = Integer.parseInt(startTime[0]) + 12;
                    } else {
                        startTimeHour = Integer.parseInt(startTime[0]);
                    }

                    if (newEvent.getNewEventInitialPanel().getPmEnd().isSelected()) {
                        endTimeHour = Integer.parseInt(endTime[0]) + 12;
                    } else {
                        endTimeHour = Integer.parseInt(endTime[0]);
                    }

                    eventArrayList.add(newEvent.getNewEventInitialPanel().getEventName().getText() + ", "
                            + newEvent.getNewEventInitialPanel().getLocationBox().getText() + ", "
                            + startDate[0] + ", " + startDate[1] + ", " + startDate[2] + ", "
                            + Integer.toString(startTimeHour) + ", " + startTime[1] + ", " + startTime[2] + ", "
                            + endDate[0] + ", " + endDate[1] + ", " + endDate[2] + ", "
                            + Integer.toString(endTimeHour) + ", " + endTime[1] + ", " + endTime[2] + ", "
                            + newEvent.getNewEventInitialPanel().getAllDay().isSelected() + ", "
                            + newEvent.getNewEventInitialPanel().getDescription().getText());

                    addEvents(getCurrentMonth());
                    setUpWeather(dateTodayArray[0], dateTodayArray[1]);
                    View.this.controller.writeToFile(eventArrayList);
                    newEvent.dispose();
                }
            });
        });
        
        initialFrame.getInitialPanel().getRightPanel().getNorthPanel().getYearButton().addActionListener((ActionEvent e) -> {
            initialFrame.getInitialPanel().getRightPanel().getNorthPanel().getMonth().setVisible(false);
            initialFrame.getInitialPanel().getRightPanel().getNorthPanel().getUpMonth().setVisible(false);
            initialFrame.getInitialPanel().getRightPanel().getNorthPanel().getDownMonth().setVisible(false);
            initialFrame.getInitialPanel().getRightPanel().getNorthPanel().getSunday().setVisible(false);
            initialFrame.getInitialPanel().getRightPanel().getNorthPanel().getMonday().setVisible(false);
            initialFrame.getInitialPanel().getRightPanel().getNorthPanel().getTuesday().setVisible(false);
            initialFrame.getInitialPanel().getRightPanel().getNorthPanel().getWednesday().setVisible(false);
            initialFrame.getInitialPanel().getRightPanel().getNorthPanel().getThursday().setVisible(false);
            initialFrame.getInitialPanel().getRightPanel().getNorthPanel().getFriday().setVisible(false);
            initialFrame.getInitialPanel().getRightPanel().getNorthPanel().getSaturday().setVisible(false);
            initialFrame.getInitialPanel().getRightPanel().getCenterPanel().setVisible(false);
            YearCenterPanel yearCenterPanel = new YearCenterPanel(dateHashMap);
            initialFrame.getInitialPanel().getRightPanel().add(yearCenterPanel, BorderLayout.CENTER);
            
        });
        
        initialFrame.getInitialPanel().getRightPanel().getNorthPanel().getMonthButton().addActionListener((ActionEvent e) -> {
            initialFrame.getInitialPanel().getRightPanel().getNorthPanel().getMonth().setVisible(true);
            initialFrame.getInitialPanel().getRightPanel().getNorthPanel().getYear().setVisible(true);
            initialFrame.getInitialPanel().getRightPanel().getNorthPanel().getUpMonth().setVisible(true);
            initialFrame.getInitialPanel().getRightPanel().getNorthPanel().getDownMonth().setVisible(true);
            initialFrame.getInitialPanel().getRightPanel().getNorthPanel().getSunday().setVisible(true);
            initialFrame.getInitialPanel().getRightPanel().getNorthPanel().getMonday().setVisible(true);
            initialFrame.getInitialPanel().getRightPanel().getNorthPanel().getTuesday().setVisible(true);
            initialFrame.getInitialPanel().getRightPanel().getNorthPanel().getWednesday().setVisible(true);
            initialFrame.getInitialPanel().getRightPanel().getNorthPanel().getThursday().setVisible(true);
            initialFrame.getInitialPanel().getRightPanel().getNorthPanel().getFriday().setVisible(true);
            initialFrame.getInitialPanel().getRightPanel().getNorthPanel().getSaturday().setVisible(true);
            initialFrame.getInitialPanel().getRightPanel().getCenterPanel().setVisible(true);
            setUpTodayView();
        });
    }

    public void setUpTodayView() {
        removeWeather();
        clearEvent();
        String[] dateTodayArray = dateToday.split(", ");
        int counterMonth = 0;
        for (int i = 1; i <= dateHashMap.get(Integer.parseInt(dateTodayArray[0]) - 1).get(1); i++) {
            if (dateHashMap.get(Integer.parseInt(dateTodayArray[0]) - 1).get(0) != 1 && Integer.parseInt(dateTodayArray[0]) != 1) {
                int numberOfDayToFill = 5 - (7 - dateHashMap.get(Integer.parseInt(dateTodayArray[0]) - 1).get(0));
                int maxNumberPreviousMonth = dateHashMap.get(Integer.parseInt(dateTodayArray[0]) - 2).get(1) - numberOfDayToFill;
                for (int k = 0; k <= numberOfDayToFill; k++) {
                    initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(k).getNumber().setText(Integer.toString(maxNumberPreviousMonth));
                    initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(k).getNumber().setFont(new Font("Times New Roman", Font.BOLD, screenSize.width / 125));
                    initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(k).getNumber().setForeground(Color.gray);
                    maxNumberPreviousMonth++;
                }
            }
            initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(dateHashMap.get(Integer.parseInt(dateTodayArray[0]) - 1).get(0) - 1 + counterMonth).getNumber().setText(Integer.toString(i));
            initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(dateHashMap.get(Integer.parseInt(dateTodayArray[0]) - 1).get(0) - 1 + counterMonth).getNumber().setFont(new Font("Times New Roman", Font.BOLD, screenSize.width / 125));
            for (int j = dateHashMap.get(Integer.parseInt(dateTodayArray[0]) - 1).get(0) - 1; j <= dateHashMap.get(Integer.parseInt(dateTodayArray[0]) - 1).get(1) + (dateHashMap.get(Integer.parseInt(dateTodayArray[0]) - 1).get(0) - 1) - 1; j++) {
                initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(j).getNumber().setForeground(Color.black);
                initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(j).setBorder(BorderFactory.createLineBorder(Color.black, 1));
            }
            counterMonth++;
            int counterMonthV2 = 1;

            for (int k = dateHashMap.get(Integer.parseInt(dateTodayArray[0]) - 1).get(1) + dateHashMap.get(Integer.parseInt(dateTodayArray[0]) - 1).get(0) - 1; k < initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().size(); k++) {
                initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(k).getNumber().setText(Integer.toString(counterMonthV2) + " ");
                initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(k).getNumber().setFont(new Font("Times New Roman", Font.BOLD, screenSize.width / 125));
                initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(k).getNumber().setForeground(Color.gray);
                counterMonthV2++;
            }
        }

        for (int i = 0; i < initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().size(); i++) {
            if (initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(i).getNumber().getText().equalsIgnoreCase(dateTodayArray[1])) {
                initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(i).setBorder(BorderFactory.createLineBorder(Color.decode("#FF9D00"), 3));
            }
        }
        initialFrame.getInitialPanel().getRightPanel().getNorthPanel().getYear().setText(dateTodayArray[2]);
        setCurrentMonth(Integer.parseInt(dateTodayArray[0]));
        addEvents(getCurrentMonth());

        setUpWeather(dateTodayArray[0], dateTodayArray[1]);
    }

    private void clearEvent() {
        for (int i = 0; i < initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().size(); i++) {
            for (int k = 0; k < eventButtonArray.size(); k++) {
                initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(i).remove(eventButtonArray.get(k));
            }
        }
        initialFrame.repaint();
    }

    private void addEvents(int currentMonth) {
        for (int i = 0; i < eventArrayList.size(); i++) {
            JButton eventButton = new JButton();
            eventButtonArray.add(eventButton);
            String[] eventListSplit = eventArrayList.get(i).split(", ");
            if (Integer.parseInt(eventListSplit[2]) == currentMonth && eventListSplit[4].equalsIgnoreCase(initialFrame.getInitialPanel().getRightPanel().getNorthPanel().getYear().getText())) {
                eventButton.setText(eventListSplit[0]);
                eventButton.setBackground(Color.decode("#FF9D00"));
                eventButton.setFocusPainted(false);
                eventButton.setFont(new Font("Times New Roman", Font.BOLD, screenSize.width / 100));
                initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(Integer.parseInt(eventListSplit[3]) + dateHashMap.get(currentMonth - 1).get(0) - 2).add(eventButton);
                initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanel().getLayout().putConstraint(SpringLayout.HORIZONTAL_CENTER, eventButton, 0, SpringLayout.HORIZONTAL_CENTER, initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(Integer.parseInt(eventListSplit[3]) + dateHashMap.get(currentMonth - 1).get(0) - 2));
                initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanel().getLayout().putConstraint(SpringLayout.VERTICAL_CENTER, eventButton, 0, SpringLayout.VERTICAL_CENTER, initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(Integer.parseInt(eventListSplit[3]) + dateHashMap.get(currentMonth - 1).get(0) - 2));
                eventButton.addActionListener((ActionEvent e) -> {
                    try {
                        newEvent = new NewEvent(screenSize);
                    } catch (ParseException ex) {
                        System.out.println(ex.getMessage());
                    }

                    newEvent.getNewEventInitialPanel().getAmStart().addActionListener((ActionEvent e1) -> {
                        newEvent.getNewEventInitialPanel().getAllDay().setSelected(false);
                        newEvent.getNewEventInitialPanel().getPmStart().setSelected(false);
                        newEvent.getNewEventInitialPanel().getStartTime().setFocusable(true);
                        newEvent.getNewEventInitialPanel().getEndTime().setFocusable(true);
                    });

                    newEvent.getNewEventInitialPanel().getPmStart().addActionListener((ActionEvent e1) -> {
                        newEvent.getNewEventInitialPanel().getAllDay().setSelected(false);
                        newEvent.getNewEventInitialPanel().getAmStart().setSelected(false);
                        newEvent.getNewEventInitialPanel().getStartTime().setFocusable(true);
                        newEvent.getNewEventInitialPanel().getEndTime().setFocusable(true);
                    });

                    newEvent.getNewEventInitialPanel().getAmEnd().addActionListener((ActionEvent e1) -> {
                        newEvent.getNewEventInitialPanel().getAllDay().setSelected(false);
                        newEvent.getNewEventInitialPanel().getPmEnd().setSelected(false);
                        newEvent.getNewEventInitialPanel().getStartTime().setFocusable(true);
                        newEvent.getNewEventInitialPanel().getEndTime().setFocusable(true);
                    });

                    newEvent.getNewEventInitialPanel().getPmEnd().addActionListener((ActionEvent e1) -> {
                        newEvent.getNewEventInitialPanel().getAllDay().setSelected(false);
                        newEvent.getNewEventInitialPanel().getAmEnd().setSelected(false);
                        newEvent.getNewEventInitialPanel().getStartTime().setFocusable(true);
                        newEvent.getNewEventInitialPanel().getEndTime().setFocusable(true);
                    });

                    newEvent.getNewEventInitialPanel().getAllDay().addActionListener((ActionEvent e1) -> {
                        if (!newEvent.getNewEventInitialPanel().getAllDay().isSelected()) {
                            newEvent.getNewEventInitialPanel().getAllDay().setSelected(false);
                            newEvent.getNewEventInitialPanel().getStartTime().setFocusable(true);
                            newEvent.getNewEventInitialPanel().getEndTime().setFocusable(true);
                        } else {
                            newEvent.getNewEventInitialPanel().getStartTime().setText("12:00:00");
                            newEvent.getNewEventInitialPanel().getAmStart().setSelected(true);
                            newEvent.getNewEventInitialPanel().getPmStart().setSelected(false);
                            newEvent.getNewEventInitialPanel().getEndTime().setText("11:59:59");
                            newEvent.getNewEventInitialPanel().getAmEnd().setSelected(false);
                            newEvent.getNewEventInitialPanel().getPmEnd().setSelected(true);
                            newEvent.getNewEventInitialPanel().getStartTime().setFocusable(false);
                            newEvent.getNewEventInitialPanel().getEndTime().setFocusable(false);
                        }
                    });

                    for (int k = 0; k < eventArrayList.size(); k++) {
                        String[] eventListSplit2 = eventArrayList.get(k).split(", ");
                        if (eventButton.getText().equalsIgnoreCase(eventListSplit2[0])) {
                            int startTimeHour;
                            int endTimeHour;
                            String startHour;
                            String startMin;
                            String startSec;
                            String endHour;
                            String endMin;
                            String endSec;
                            String startMonth;
                            String startDay;
                            String startYear;
                            String endMonth;
                            String endDay;
                            String endYear;
                            if (Integer.parseInt(eventListSplit[5]) > 12) {
                                startTimeHour = Integer.parseInt(eventListSplit2[5]) - 12;
                            } else {
                                startTimeHour = Integer.parseInt(eventListSplit2[5]);
                            }
                            if (Integer.parseInt(eventListSplit[11]) > 12) {
                                endTimeHour = Integer.parseInt(eventListSplit2[11]) - 12;
                            } else {
                                endTimeHour = Integer.parseInt(eventListSplit2[11]);
                            }

                            if (startTimeHour < 10) {
                                startHour = String.format("%02d", startTimeHour);
                            } else {
                                startHour = Integer.toString(startTimeHour);
                            }

                            if (Integer.parseInt(eventListSplit2[6]) < 10) {
                                startMin = String.format("%02d", Integer.parseInt(eventListSplit2[6]));
                            } else {
                                startMin = eventListSplit2[6];
                            }

                            if (Integer.parseInt(eventListSplit2[7]) < 10) {
                                startSec = String.format("%02d", Integer.parseInt(eventListSplit2[7]));
                            } else {
                                startSec = eventListSplit2[7];
                            }

                            if (endTimeHour < 10) {
                                endHour = String.format("%02d", endTimeHour);
                            } else {
                                endHour = Integer.toString(endTimeHour);
                            }

                            if (Integer.parseInt(eventListSplit2[12]) < 10) {
                                endMin = String.format("%02d", Integer.parseInt(eventListSplit2[12]));
                            } else {
                                endMin = eventListSplit2[12];
                            }

                            if (Integer.parseInt(eventListSplit2[13]) < 10) {
                                endSec = String.format("%02d", Integer.parseInt(eventListSplit2[13]));
                            } else {
                                endSec = eventListSplit2[13];
                            }

                            if (Integer.parseInt(eventListSplit2[2]) < 10) {
                                startMonth = String.format("%02d", Integer.parseInt(eventListSplit2[2]));
                            } else {
                                startMonth = eventListSplit2[2];
                            }

                            if (Integer.parseInt(eventListSplit2[3]) < 10) {
                                startDay = String.format("%02d", Integer.parseInt(eventListSplit2[3]));
                            } else {
                                startDay = eventListSplit2[3];
                            }

                            if (Integer.parseInt(eventListSplit2[4]) < 10) {
                                startYear = String.format("%02d", Integer.parseInt(eventListSplit2[4]));
                            } else {
                                startYear = eventListSplit2[4];
                            }

                            if (Integer.parseInt(eventListSplit2[8]) < 10) {
                                endMonth = String.format("%02d", Integer.parseInt(eventListSplit2[8]));
                            } else {
                                endMonth = eventListSplit2[8];
                            }

                            if (Integer.parseInt(eventListSplit2[9]) < 10) {
                                endDay = String.format("%02d", Integer.parseInt(eventListSplit2[9]));
                            } else {
                                endDay = eventListSplit2[9];
                            }

                            if (Integer.parseInt(eventListSplit2[10]) < 10) {
                                endYear = String.format("%02d", Integer.parseInt(eventListSplit2[10]));
                            } else {
                                endYear = eventListSplit2[10];
                            }

                            newEvent.getNewEventInitialPanel().getEventName().setText(eventListSplit2[0]);
                            newEvent.getNewEventInitialPanel().getLocationBox().setText(eventListSplit2[1]);
                            newEvent.getNewEventInitialPanel().getStartDate().setText(startMonth + "/" + startDay + "/" + startYear);
                            newEvent.getNewEventInitialPanel().getStartTime().setText(startHour + ":" + startMin + ":" + startSec);
                            newEvent.getNewEventInitialPanel().getEndDate().setText(endMonth + "/" + endDay + "/" + endYear);
                            newEvent.getNewEventInitialPanel().getEndTime().setText(endHour + ":" + endMin + ":" + endSec);
                            newEvent.getNewEventInitialPanel().getDescription().setText(eventListSplit2[15]);

                            if (eventListSplit2[14].equalsIgnoreCase("true")) {
                                newEvent.getNewEventInitialPanel().getAllDay().setSelected(true);
                            }

                            if (Integer.parseInt(eventListSplit2[5]) > 12) {
                                newEvent.getNewEventInitialPanel().getAmStart().setSelected(false);
                                newEvent.getNewEventInitialPanel().getPmStart().setSelected(true);
                            } else {
                                newEvent.getNewEventInitialPanel().getPmStart().setSelected(false);
                                newEvent.getNewEventInitialPanel().getAmStart().setSelected(true);
                            }

                            if (Integer.parseInt(eventListSplit2[11]) > 12) {
                                newEvent.getNewEventInitialPanel().getAmEnd().setSelected(false);
                                newEvent.getNewEventInitialPanel().getPmEnd().setSelected(true);
                            } else {
                                newEvent.getNewEventInitialPanel().getPmEnd().setSelected(false);
                                newEvent.getNewEventInitialPanel().getAmEnd().setSelected(true);
                            }
                        }
                    }

                    newEvent.setSize(screenSize.height / 2, screenSize.width / 2);
                    newEvent.setLocationRelativeTo(null);
                    newEvent.setVisible(true);

                    newEvent.getNewEventInitialPanel().getSave().addActionListener((ActionEvent e1) -> {
                        String[] startDate = newEvent.getNewEventInitialPanel().getStartDate().getText().split("/");
                        String[] startTime = newEvent.getNewEventInitialPanel().getStartTime().getText().split(":");
                        String[] endDate = newEvent.getNewEventInitialPanel().getEndDate().getText().split("/");
                        String[] endTime = newEvent.getNewEventInitialPanel().getEndTime().getText().split(":");
                        int startTimeHour;
                        int endTimeHour;
                        newEvent.dispose();
                        int eventNumber = 0;

                        for (int j = 0; j < eventArrayList.size(); j++) {
                            String[] eventArraySplit = eventArrayList.get(j).split(", ");
                            if (newEvent.getNewEventInitialPanel().getEventName().getText().equals(eventArraySplit[0])) {
                                eventNumber = j;
                            }
                        }

                        if (newEvent.getNewEventInitialPanel().getPmStart().isSelected()) {
                            startTimeHour = Integer.parseInt(startTime[0]) + 12;
                        } else {
                            startTimeHour = Integer.parseInt(startTime[0]);
                        }

                        if (newEvent.getNewEventInitialPanel().getPmEnd().isSelected()) {
                            endTimeHour = Integer.parseInt(endTime[0]) + 12;
                        } else {
                            endTimeHour = Integer.parseInt(endTime[0]);
                        }

                        eventArrayList.set(eventNumber, newEvent.getNewEventInitialPanel().getEventName().getText() + ", "
                                + newEvent.getNewEventInitialPanel().getLocationBox().getText() + ", "
                                + startDate[0] + ", " + startDate[1] + ", " + startDate[2] + ", "
                                + Integer.toString(startTimeHour) + ", " + startTime[1] + ", " + startTime[2] + ", "
                                + endDate[0] + ", " + endDate[1] + ", " + endDate[2] + ", "
                                + Integer.toString(endTimeHour) + ", " + endTime[1] + ", " + endTime[2] + ", "
                                + newEvent.getNewEventInitialPanel().getAllDay().isSelected() + ", "
                                + newEvent.getNewEventInitialPanel().getDescription().getText());

                        clearEvent();
                        addEvents(currentMonth);
                        JOptionPane.showMessageDialog(initialFrame, "Event Updated!");
                        View.this.controller.writeToFile(eventArrayList);
                    });

                    newEvent.getNewEventInitialPanel().getDelete().addActionListener((ActionEvent e1) -> {
                        int areYouSure = JOptionPane.showConfirmDialog(newEvent.getNewEventInitialPanel(), "Are you sure you want to delete this event?");
                        if (areYouSure == 0) {
                            newEvent.dispose();
                            int eventNumber = 0;

                            for (int j = 0; j < eventArrayList.size(); j++) {
                                String[] eventArraySplit = eventArrayList.get(j).split(", ");
                                if (newEvent.getNewEventInitialPanel().getEventName().getText().equals(eventArraySplit[0])) {
                                    eventNumber = j;
                                }
                            }
                            eventArrayList.remove(eventNumber);
                            clearEvent();
                            addEvents(currentMonth);
                            JOptionPane.showMessageDialog(initialFrame, "Event Deleted!");
                            View.this.controller.writeToFile(eventArrayList);
                        }
                    });
                });
            }
        }
        initialFrame.validate();
        initialFrame.repaint();
    }

    private int getCurrentMonth() {
        int currentMonth = 0;
        if (initialFrame.getInitialPanel().getRightPanel().getNorthPanel().getMonth().getText().equalsIgnoreCase("Januaray")) {
            currentMonth = 1;
        } else if (initialFrame.getInitialPanel().getRightPanel().getNorthPanel().getMonth().getText().equalsIgnoreCase("February")) {
            currentMonth = 2;
        } else if (initialFrame.getInitialPanel().getRightPanel().getNorthPanel().getMonth().getText().equalsIgnoreCase("March")) {
            currentMonth = 3;
        } else if (initialFrame.getInitialPanel().getRightPanel().getNorthPanel().getMonth().getText().equalsIgnoreCase("April")) {
            currentMonth = 4;
        } else if (initialFrame.getInitialPanel().getRightPanel().getNorthPanel().getMonth().getText().equalsIgnoreCase("May")) {
            currentMonth = 5;
        } else if (initialFrame.getInitialPanel().getRightPanel().getNorthPanel().getMonth().getText().equalsIgnoreCase("June")) {
            currentMonth = 6;
        } else if (initialFrame.getInitialPanel().getRightPanel().getNorthPanel().getMonth().getText().equalsIgnoreCase("July")) {
            currentMonth = 7;
        } else if (initialFrame.getInitialPanel().getRightPanel().getNorthPanel().getMonth().getText().equalsIgnoreCase("August")) {
            currentMonth = 8;
        } else if (initialFrame.getInitialPanel().getRightPanel().getNorthPanel().getMonth().getText().equalsIgnoreCase("September")) {
            currentMonth = 9;
        } else if (initialFrame.getInitialPanel().getRightPanel().getNorthPanel().getMonth().getText().equalsIgnoreCase("October")) {
            currentMonth = 10;
        } else if (initialFrame.getInitialPanel().getRightPanel().getNorthPanel().getMonth().getText().equalsIgnoreCase("November")) {
            currentMonth = 11;
        } else if (initialFrame.getInitialPanel().getRightPanel().getNorthPanel().getMonth().getText().equalsIgnoreCase("December")) {
            currentMonth = 12;
        }
        return currentMonth;
    }

    private void setCurrentMonth(int currentMonth) {
        switch (currentMonth) {
            case 1:
                initialFrame.getInitialPanel().getRightPanel().getNorthPanel().getMonth().setText("January");
                break;
            case 2:
                initialFrame.getInitialPanel().getRightPanel().getNorthPanel().getMonth().setText("February");
                break;
            case 3:
                initialFrame.getInitialPanel().getRightPanel().getNorthPanel().getMonth().setText("March");
                break;
            case 4:
                initialFrame.getInitialPanel().getRightPanel().getNorthPanel().getMonth().setText("April");
                break;
            case 5:
                initialFrame.getInitialPanel().getRightPanel().getNorthPanel().getMonth().setText("May");
                break;
            case 6:
                initialFrame.getInitialPanel().getRightPanel().getNorthPanel().getMonth().setText("June");
                break;
            case 7:
                initialFrame.getInitialPanel().getRightPanel().getNorthPanel().getMonth().setText("July");
                break;
            case 8:
                initialFrame.getInitialPanel().getRightPanel().getNorthPanel().getMonth().setText("August");
                break;
            case 9:
                initialFrame.getInitialPanel().getRightPanel().getNorthPanel().getMonth().setText("September");
                break;
            case 10:
                initialFrame.getInitialPanel().getRightPanel().getNorthPanel().getMonth().setText("October");
                break;
            case 11:
                initialFrame.getInitialPanel().getRightPanel().getNorthPanel().getMonth().setText("November");
                break;
            case 12:
                initialFrame.getInitialPanel().getRightPanel().getNorthPanel().getMonth().setText("December");
                break;
            default:
                break;
        }
    }

    private void setUpWeather(String month, String day) {
        if (month.equalsIgnoreCase(Integer.toString(getCurrentMonth()))) {
            for (int i = 0; i < initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().size(); i++) {
                String dayNumber = initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(i).getNumber().getText();
                dayNumber = dayNumber.replaceAll(" ", "");
                if (dayNumber.equalsIgnoreCase(day)) {
                    int dayCounter = 0;
                    for (int k = i; k < i + 5; k++) {
                        JLabel tempLabel = new JLabel();
                        tempLabel.setSize(new Dimension(100, 10));
                        tempLabel.setForeground(Color.decode("#6b6b6b"));
                        String setTextString = "Low: " + dayHashMap.get(dayCounter).get(0) + "°F  Hi: " + dayHashMap.get(dayCounter).get(1) + "°F";
                        tempLabel.setFont(new Font("Times New Roman", Font.BOLD, screenSize.width / 150));
                        tempLabel.setText(setTextString);
                        weatherLabelArray.add(tempLabel);
                        initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(k).add(tempLabel);
                        initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(k).getLayout().putConstraint(SpringLayout.EAST, tempLabel, -5, SpringLayout.EAST, initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(k));
                        setIcon(dayHashMap.get(dayCounter).get(2), k, tempLabel);
                        initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(k).validate();
                        initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(k).repaint();
                        dayCounter++;
                    }
                }
            }
        }
    }

    private void setIcon(String iconNumber, int panelNumber, JLabel tempLabel) {
        JButton icon = new JButton();
        icon.setIcon(setIcon(Integer.parseInt(iconNumber)));
        icon.setPreferredSize(new Dimension(40, 40));
        icon.setContentAreaFilled(false);
        icon.setFocusPainted(false);
        icon.setBorder(BorderFactory.createEmptyBorder());
        initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(panelNumber).add(icon);
        initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(panelNumber).getLayout().putConstraint(SpringLayout.EAST, icon, 0, SpringLayout.WEST, tempLabel);
    }

    private ImageIcon setIcon(int iconNumber) {
        ImageIcon icon = new ImageIcon();
        switch (iconNumber) {
            case 1:
                icon = new ImageIcon("Resources/Forecast_Icons/1.jpg");
                break;
            case 2:
                icon = new ImageIcon("Resources/Forecast_Icons/2.jpg");
                break;
            case 3:
                icon = new ImageIcon("Resources/Forecast_Icons/3.jpg");
                break;
            case 4:
                icon = new ImageIcon("Resources/Forecast_Icons/4.jpg");
                break;
            case 5:
                icon = new ImageIcon("Resources/Forecast_Icons/5.jpg");
                break;
            case 6:
                icon = new ImageIcon("Resources/Forecast_Icons/6.jpg");
                break;
            case 7:
                icon = new ImageIcon("Resources/Forecast_Icons/7.jpg");
                break;
            case 8:
                icon = new ImageIcon("Resources/Forecast_Icons/8.jpg");
                break;
            case 11:
                icon = new ImageIcon("Resources/Forecast_Icons/11.jpg");
                break;
            case 12:
                icon = new ImageIcon("Resources/Forecast_Icons/12.jpg");
                break;
            case 13:
                icon = new ImageIcon("Resources/Forecast_Icons/13.jpg");
                break;
            case 14:
                icon = new ImageIcon("Resources/Forecast_Icons/14.jpg");
                break;
            case 15:
                icon = new ImageIcon("Resources/Forecast_Icons/15.jpg");
                break;
            case 16:
                icon = new ImageIcon("Resources/Forecast_Icons/16.jpg");
                break;
            case 17:
                icon = new ImageIcon("Resources/Forecast_Icons/17.jpg");
                break;
            case 18:
                icon = new ImageIcon("Resources/Forecast_Icons/18.jpg");
                break;
            case 19:
                icon = new ImageIcon("Resources/Forecast_Icons/19.jpg");
                break;
            case 20:
                icon = new ImageIcon("Resources/Forecast_Icons/20.jpg");
                break;
            case 21:
                icon = new ImageIcon("Resources/Forecast_Icons/21.jpg");
                break;
            case 22:
                icon = new ImageIcon("Resources/Forecast_Icons/22.jpg");
                break;
            case 23:
                icon = new ImageIcon("Resources/Forecast_Icons/23.jpg");
                break;
            case 24:
                icon = new ImageIcon("Resources/Forecast_Icons/24.jpg");
                break;
            case 25:
                icon = new ImageIcon("Resources/Forecast_Icons/25.jpg");
                break;
            case 26:
                icon = new ImageIcon("Resources/Forecast_Icons/26.jpg");
                break;
            case 29:
                icon = new ImageIcon("Resources/Forecast_Icons/29.jpg");
                break;
            case 30:
                icon = new ImageIcon("Resources/Forecast_Icons/30.jpg");
                break;
            case 31:
                icon = new ImageIcon("Resources/Forecast_Icons/31.jpg");
                break;
            case 32:
                icon = new ImageIcon("Resources/Forecast_Icons/32.jpg");
                break;
            case 33:
                icon = new ImageIcon("Resources/Forecast_Icons/33.jpg");
                break;
            case 34:
                icon = new ImageIcon("Resources/Forecast_Icons/34.jpg");
                break;
            case 35:
                icon = new ImageIcon("Resources/Forecast_Icons/35.jpg");
                break;
            case 36:
                icon = new ImageIcon("Resources/Forecast_Icons/36.jpg");
                break;
            case 37:
                icon = new ImageIcon("Resources/Forecast_Icons/37.jpg");
                break;
            case 38:
                icon = new ImageIcon("Resources/Forecast_Icons/38.jpg");
                break;
            case 39:
                icon = new ImageIcon("Resources/Forecast_Icons/39.jpg");
                break;
            case 40:
                icon = new ImageIcon("Resources/Forecast_Icons/40.jpg");
                break;
            case 41:
                icon = new ImageIcon("Resources/Forecast_Icons/41.jpg");
                break;
            case 42:
                icon = new ImageIcon("Resources/Forecast_Icons/42.jpg");
                break;
            case 43:
                icon = new ImageIcon("Resources/Forecast_Icons/43.jpg");
                break;
            case 44:
                icon = new ImageIcon("Resources/Forecast_Icons/44jpg");
                break;
            default:
                break;
        }
        return icon;
    }

    private void removeWeather() {
        for (int i = 0; i < initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().size(); i++) {
            for (int k = 0; k < weatherLabelArray.size(); k++) {
                initialFrame.getInitialPanel().getRightPanel().getCenterPanel().getDayPanelArray().get(i).remove(weatherLabelArray.get(k));
            }
        }
        initialFrame.repaint();
    }
}
