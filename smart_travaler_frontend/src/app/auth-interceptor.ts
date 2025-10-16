import { HttpInterceptorFn } from '@angular/common/http';
import { isPlatformBrowser } from '@angular/common';
import { inject, PLATFORM_ID } from '@angular/core';

/**
 * Intercepts outgoing HTTP requests to add the JWT authorization header.
 * This interceptor is platform-aware and only accesses localStorage in the browser.
 */
export const authInterceptor: HttpInterceptorFn = (req, next) => {
  // Inject PLATFORM_ID to determine if the code is running on the server or in the browser.
  const platformId = inject(PLATFORM_ID);

  // Guard against running this code on the server.
  if (isPlatformBrowser(platformId)) {
    // This code will only run in a browser environment.
    const authToken = localStorage.getItem('auth_token');

    if (authToken) {
      // Clone the request to add the new header.
      const clonedReq = req.clone({
        headers: req.headers.set('Authorization', `Bearer ${authToken}`)
      });
      // Pass the cloned request to the next handler.
      return next(clonedReq);
    }
  }

  // If on the server or if no token is found, pass the original request along.
  return next(req);
};