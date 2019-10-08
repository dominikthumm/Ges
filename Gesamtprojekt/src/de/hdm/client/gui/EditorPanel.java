package de.hdm.client.gui;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.client.GreetingService;
import de.hdm.client.GreetingServiceAsync;
import de.hdm.shared.bo.tupel;

public class EditorPanel extends VerticalPanel {

	private Label l1 = new Label("Hier Text einfügen!"); 
	
	private TextBox tb1 = new TextBox();
	
	private Button b1 = new Button("Änderungen speichern");
	
	private Button b2 = new Button ("Inhalt löschen");  // Für delete
	
	private Button getDataButton = new Button("HIer bekommen Sie die Daten!");
	
	private static GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

	
	public EditorPanel() { //Standart Konstruktor Label/ TextBox/ Button geadded
		this.add(l1);
		this.add(tb1);
		this.add(b1);
		this.add(b2);  // Hinzugefügt für delete
		aalClickHandler a1 = new aalClickHandler(); // Clickhandler Instanz a1 erstellt (nicht anonym)
	    this.b1.addClickHandler(a1);                // a1 ist eine Instanz der Klasse aalClickhandler, die das Interface Clickhandler implementiert
	    this.add(getDataButton);
	    getDataButton.addClickHandler(new dataButtonClickHandler());
	    deleteClickHandler dk = new deleteClickHandler(); // Neuer delete ClickHandler
	    this.b2.addClickHandler(dk);  // dem Editor Panel hinzugefügt
	
	}
	
	
	public void onLoad() {
		
		
		
	}
	
	public class aalClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			
			greetingService.greetServer(tb1.getText(), new AsyncCallback<String>() {

				@Override
				public void onFailure(Throwable caught) {
					
					l1.setText(caught.getMessage());
					
				}

				@Override
				public void onSuccess(String result) {
					// TODO Auto-generated method stub
					
					
				}				
	});
			
			
		}
		
		
		
	}
	
	public class deleteClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {			
		
			greetingService.getAllData(new AsyncCallback<ArrayList<tupel>>(){

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				EditorPanel.this.add(new Label(caught.getMessage()));
				EditorPanel.this.add(new Label(caught.toString()));
				EditorPanel.this.add(new Label(caught.getLocalizedMessage()));
				

				System.out.println("test");
				
			}

			
			@Override
			public void onSuccess(ArrayList<tupel> result) {
				// TODO Auto-generated method stub
				System.out.println("Hallo");

				
				ArrayList<tupel> liste = result;
				
				for(int i = 0; i < liste.size(); i++) {
					EditorPanel.this.add(new Label("inhalt: " + liste.get(i).getInhalt() + " date: " + liste.get(i).getDate()));
				}
				
			}				
	});
			
			
		}
		
		
		
	}
	
	
	public class dataButtonClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			
			greetingService.getAllData(new AsyncCallback<ArrayList<tupel>>(){

				@Override
				public void onFailure(Throwable caught) {
					
					EditorPanel.this.add(new Label(caught.getMessage()));
					EditorPanel.this.add(new Label(caught.toString()));
					EditorPanel.this.add(new Label(caught.getLocalizedMessage()));
					
				}

				@Override
				public void onSuccess(ArrayList<tupel> result) {
					// Daten aus der Datenbank soll angezeigt werden
					// Result des RPC calls --> hier anzeigen der Daten
					// Datentyp array list 
					
					System.out.println("Hallo");

					
					ArrayList<tupel> liste = result;
					
					for(int i = 0; i < liste.size(); i++) {
						EditorPanel.this.add(new Label("inhalt: " + liste.get(i).getInhalt() + " date: " + liste.get(i).getDate()));
					}
					
				}

			});
			
		}
	}
	
	
}
