import javax.swing.*;
import java.awt.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MainPanel extends JPanel
{
    MainPanel()
    {
        final String url = "http://planwe.pollub.pl/plan.php?type=0&id=12791&winW=1904&winH=947&loadBG=000000";

        try 
        {
            final Document document = Jsoup.connect(url).get();
            Elements divElements = document.select("div.coursediv");//take all classes from the plan 

            for (Element divElement : divElements) 
            {
                if(divElement.id().equals("testBox")) continue; //last element in this elements is useless

                String styleAttribute = divElement.attr("style");
                String[] styleParts = styleAttribute.split(";");
                int width=0, height=0, top=0, left=0;
                Color backgroundColor=Color.RED;

                for (String part : styleParts) 
                {
                    if(part.contains("top:")) 
                    {
                        top = Integer.parseInt(part.split(":")[1].trim().replace("px", ""));
                    } 
                    else if(part.contains("left:")) 
                    {
                        left = Integer.parseInt(part.split(":")[1].trim().replace("px", ""));
                    }
                    else if(part.contains("background-color:"))
                    {
                        backgroundColor = Color.decode(part.split(":")[1].trim());
                    }
                    else if(part.contains("width:"))
                    {
                        width = Integer.parseInt(part.split(":")[1].trim().replace("px", ""));
                    }
                    else if(part.contains("height:"))
                    {
                        height = Integer.parseInt(part.split(":")[1].trim().replace("px", ""));
                    }
                }

                String courseName = divElement.ownText().split(",")[0];
                String details = divElement.ownText().substring(courseName.length() + 2);

                JLabel label = new JLabel("<html>" + courseName + "<br>" + details + "</html>");
                label.setBounds(left, top, 265, height);
                label.setBorder(BorderFactory.createLineBorder(backgroundColor));
                label.setOpaque(true);
                label.setBackground(backgroundColor);
                //label.setForeground(Color.BLUE);
                label.setHorizontalAlignment(JLabel.CENTER);
                label.setVerticalAlignment(JLabel.CENTER);
                this.add(label);
            }

            Elements cdElements = document.select("div.cd");

            int k=0;
            for (Element divElement : cdElements) 
            {
                k++;
                if(k>7 && k<22) continue;

                String styleAttribute = divElement.attr("style");
                String[] styleParts = styleAttribute.split(";");
                int width=0, height=0, top=0, left=0;
                
                for (String part : styleParts) 
                {
                    if(part.contains("top:")) 
                    {
                        top = Integer.parseInt(part.split(":")[1].trim().replace("px", ""));
                    } 
                    else if(part.contains("left:")) 
                    {
                        left = Integer.parseInt(part.split(":")[1].trim().replace("px", ""));
                    }
                    else if(part.contains("width:"))
                    {
                        width = Integer.parseInt(part.split(":")[1].trim().replace("px", ""));
                    }
                    else if(part.contains("height:"))
                    {
                        height = Integer.parseInt(part.split(":")[1].trim().replace("px", ""));
                    }
                }

                JLabel label = new JLabel(divElement.text());
                label.setBounds(left, top, width, height);
                label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                label.setOpaque(true);
                label.setHorizontalAlignment(JLabel.CENTER);
                label.setVerticalAlignment(JLabel.CENTER);
                this.add(label);
            }
            
            for (Element divElement : document.select("div.cdS.cTop")) 
            {
                String styleAttribute = divElement.attr("style");
                String[] styleParts = styleAttribute.split(";");
                int width=0, height=0, top=0, left=0;
                
                for (String part : styleParts) 
                {
                    if(part.contains("top:")) 
                    {
                        top = Integer.parseInt(part.split(":")[1].trim().replace("px", ""));
                    } 
                    else if(part.contains("left:")) 
                    {
                        left = Integer.parseInt(part.split(":")[1].trim().replace("px", ""));
                    }
                    else if(part.contains("width:"))
                    {
                        width = Integer.parseInt(part.split(":")[1].trim().replace("px", ""));
                    }
                    else if(part.contains("height:"))
                    {
                        height = Integer.parseInt(part.split(":")[1].trim().replace("px", ""));
                    }
                }

                JLabel label = new JLabel("");
                label.setBounds(left, top, width, height);
                label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                label.setOpaque(true);
                label.setHorizontalAlignment(JLabel.CENTER);
                label.setVerticalAlignment(JLabel.CENTER);
                this.add(label);
            }

            for (Element divElement : document.select("div.cdS.cBottom")) 
            {
                String styleAttribute = divElement.attr("style");
                String[] styleParts = styleAttribute.split(";");
                int width=0, height=0, top=0, left=0;
                
                for (String part : styleParts) 
                {
                    if(part.contains("top:")) 
                    {
                        top = Integer.parseInt(part.split(":")[1].trim().replace("px", ""));
                    } 
                    else if(part.contains("left:")) 
                    {
                        left = Integer.parseInt(part.split(":")[1].trim().replace("px", ""));
                    }
                    else if(part.contains("width:"))
                    {
                        width = Integer.parseInt(part.split(":")[1].trim().replace("px", ""));
                    }
                    else if(part.contains("height:"))
                    {
                        height = Integer.parseInt(part.split(":")[1].trim().replace("px", ""));
                    }
                }

                JLabel label = new JLabel("");
                label.setBounds(left, top, width, height);
                label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                label.setOpaque(true);
                label.setHorizontalAlignment(JLabel.CENTER);
                label.setVerticalAlignment(JLabel.CENTER);
                this.add(label);
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }   
    }
}
