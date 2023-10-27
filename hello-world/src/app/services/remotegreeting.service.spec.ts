import { TestBed } from '@angular/core/testing';

import { RemotegreetingService } from './remotegreeting.service';

describe('RemotegreetingService', () => {
  let service: RemotegreetingService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RemotegreetingService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
