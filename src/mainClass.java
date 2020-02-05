import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


public class mainClass
{
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        List<Flight> list = new ArrayList<>();
        int number_flight , seats, passagers, optiune, x, y, bags, bag;

        System.out.println("How many flights do we have today?");
        System.out.print("Write here : ");
        number_flight = scan.nextInt();

        for(int i = 1 ; i <= number_flight ; i++)
        {
            System.out.println("Number of flight : " + i);
            System.out.print("Add seats : ");
            seats = scan.nextInt();
            System.out.print("Add passagers : ");
            passagers = scan.nextInt();
            System.out.print("Add bags(MAX " + (2 * passagers) + ") :");
            bag = scan.nextInt();
            if(passagers <= seats && bag <= passagers * 2)
            {
                list.add(new Flight(seats, i, passagers, bag));
            }
            else
            {
                if(passagers > seats)
                {
                    System.out.println("Too many passagers, try again! ");
                }
                else
                {
                    System.out.println("To many bags, try again!");
                }
                i--;
            }
        }

        do
        {
            System.out.println("1.Add one flight");
            System.out.println("2.Add more flights");
            System.out.println("3.See all flight");
            System.out.println("4.Add one passager");
            System.out.println("5.Add more passagers");
            System.out.println("6.Delete flight");
            System.out.println("7.Exit");
            optiune = scan.nextInt();

            switch(optiune)
            {
                case 1 :

                    System.out.println("Number of flight : " + (list.size()+1));
                    System.out.print("Add seats : ");
                    seats = scan.nextInt();
                    System.out.print("Add passagers : ");
                    passagers = scan.nextInt();
                    System.out.print("Add bags(MAX " + (2 * passagers) + ") :");
                    bag = scan.nextInt();
                    if(passagers <= seats && bag <= passagers * 2)
                    {
                        list.add(new Flight(seats, (list.size()+1), passagers, bag));
                    }
                    else
                    {
                        if(passagers > seats)
                        {
                            System.out.println("Too many passagers, try again! ");
                        }
                        else
                        {
                            System.out.println("To many bags, try again!");
                        }
                    }
                    break;

                case 2 :

                    System.out.println("How many passagers do you want to add?");
                    System.out.print("Write here  :");
                    x = scan.nextInt();

                    for(int i = 1 ; i <= x ; i++)
                    {
                        System.out.println("Number of flight : " + (list.size()+1));
                        System.out.print("Add seats : ");
                        seats = scan.nextInt();
                        System.out.print("Add passagers : ");
                        passagers = scan.nextInt();
                        System.out.print("Add bags(MAX " + (2 * passagers) + ") :");
                        bag = scan.nextInt();
                        if(passagers <= seats && bag <= passagers * 2)
                        {
                            list.add(new Flight(seats, (list.size()+1), passagers, bag));
                        }
                        else
                        {
                            if(passagers > seats)
                            {
                                System.out.println("Too many passagers, try again! ");
                            }
                            else
                            {
                                System.out.println("To many bags, try again!");
                            }
                        }
                    }

                    break;

                case 3 :

                    for(Flight f : list) {
                        System.out.println(f);
                    }
                    break;

                case 4:

                if(list.size() > 0)
                {
                    System.out.println("In which of the flights do you want to add a passenger?");
                    System.out.print("Write here : ");
                    x = scan.nextInt();
                    System.out.println("How many bags does he have?");
                    System.out.print("Write here(1/2) : ");
                    bag = scan.nextInt();

                    if(list.get(x-1).getPassagers() < list.get(x-1).getSeats() && (bag <= 2 && bag >= 0))
                    {
                        list.get(x-1).add1Passager(bag);
                    }
                    else
                    {
                        System.out.println("Too much passagers/bags");
                    }
                }
                else
                {
                    System.out.println("There are no flights");
                }
                break;

                case 5 :

                    if(list.size() > 0)
                    {
                        System.out.println("In which of the flights do you want to add passengers?");
                        System.out.print("Write here : ");
                        x = scan.nextInt();
                        System.out.println("How many people do you want to add?");
                        System.out.print("Write here : ");
                        y = scan.nextInt();
                        System.out.println("How many bags does they have?");
                        System.out.print("Write here(MAX " + (y*2) + ") : ");
                        bag = scan.nextInt();

                        if(list.get(x-1).getPassagers() + y <= list.get(x-1).getSeats() && (bag <= (y*2) && bag >= 0))
                        {
                            list.get(x-1).addMorePassager(y,bag);
                        }
                        else
                        {
                            System.out.println("Too much passagers/bags");
                        }
                    }
                    else
                    {
                        System.out.println("There are no flights");
                    }

                    break;

                case 6 :

                    if(list.size() > 0)
                    {
                        System.out.println("What flight do you want to delete?");
                        System.out.print("Write here : ");
                        x = scan.nextInt();
                        list.remove(x - 1);

                        for(int i = x-1 ; i < list.size() ; i++)
                        {
                            list.get(i).setNumber(i+1);
                        }
                    }
                    else
                    {
                        System.out.println("There are no flights");
                    }
                    break;

                case 7 :

                    System.out.println("Good bye!");
                    break;

                default :
                    System.out.println("This option doesn't exist.");
            }

        }
        while(optiune != 7);

    }
}
