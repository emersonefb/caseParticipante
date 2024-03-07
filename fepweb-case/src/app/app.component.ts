import { Component, ElementRef, ViewChild } from '@angular/core';
import { MatIconRegistry } from '@angular/material/icon';
import { DomSanitizer } from '@angular/platform-browser';
import { Router } from '@angular/router';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  
  title = 'fepweb-case';
  constructor(
    private router: Router,
    iconRegistry: MatIconRegistry,
    sanitizer: DomSanitizer,
) { 
  iconRegistry.addSvgIcon(
    'hemo',
    sanitizer.bypassSecurityTrustResourceUrl('assets/images/home.svg'));
  iconRegistry.addSvgIcon(
    'brazil',
    sanitizer.bypassSecurityTrustResourceUrl('assets/images/brazil.svg'));
}

navigate(menu: string) {
    this.router.navigate([menu]);  
}
}
